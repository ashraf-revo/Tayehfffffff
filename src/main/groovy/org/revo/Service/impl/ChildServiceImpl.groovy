package org.revo.Service.impl

import org.revo.Repository.ChildRepository
import org.revo.Repository.SuggestedChildRepository
import org.revo.Service.ChildService
import org.revo.Service.CloudinaryService
import org.revo.Service.PersonService
import org.revo.domain.Child
import org.revo.domain.Person
import org.revo.domain.RevoEnum
import org.revo.domain.SuggestedChild
import org.revo.model.SearchCriteria
import org.revo.model.status
import org.revo.model.uids
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by ashraf on 2/5/2016.
 */
@Service
class ChildServiceImpl implements ChildService {
    @Autowired
    ChildRepository childRepository
    @Autowired
    PersonService personService
    @Autowired
    SkybiometryImpl skybiometry
    @Autowired
    CloudinaryService cloudinaryService
    @Autowired
    SuggestedChildRepository suggestedChildRepository
    @Autowired
    MongoOperations mongoOperations

    @Transactional
    @Override
    Child save(Child child) {
        Person person = personService.findCurrent()
        child.person = person
        child = childRepository.save(child)
        personService.addChild(person, child)
        child
    }

    @Transactional
    @Override
    Child addUid(String l, String s) {
        def one = childRepository.findOne(l)
        one.uid = s
        childRepository.save(one)
    }

    @Override
    Child findOne(String l) {
        childRepository.findOne(l)
    }

    @Override
    List<Child> findAllByUid(List<String> uuid) {
        childRepository.findByUidIn(uuid)
    }

    @Override
    List<Child> findAll() {
        childRepository.findAll()
    }

    @Override
    List<Child> search(SearchCriteria criteria) {
        List<Criteria> list = []
        Criteria c = new Criteria()

        if (criteria.name) list.add(Criteria.where("name").regex(criteria.name))

        if (criteria.gender && (criteria.gender.equalsIgnoreCase("male") || criteria.gender.equalsIgnoreCase("female"))) {
            if (criteria.gender.equalsIgnoreCase("male")) list.add(Criteria.where("gender").is(RevoEnum.Gender.Male))
            if (criteria.gender.equalsIgnoreCase("female")) list.add(Criteria.where("gender").is(RevoEnum.Gender.FeMale))
        }
        if (criteria.state && (criteria.state.equalsIgnoreCase("lost") || criteria.state.equalsIgnoreCase("found"))) {
            if (criteria.state.equalsIgnoreCase("found")) list.add(Criteria.where("state").is(RevoEnum.State.Found))
            if (criteria.state.equalsIgnoreCase("lost")) list.add(Criteria.where("state").is(RevoEnum.State.Lost))
        }

        if (criteria.age1 && criteria.age2) {
            list.add(Criteria.where("age").lte(criteria.age1))
            list.add(Criteria.where("age").gte(criteria.age2))
        }
        if (criteria.date1 && criteria.date2) {
            list.add(Criteria.where("createdDate").lte(criteria.date1))
            list.add(Criteria.where("createdDate").gte(criteria.date2))
        }
        Query query

        if (list.size()>0)
        query= new Query(c.andOperator(list.toArray() as Criteria[]))
        else query=new Query()
        query.with(new Sort(Sort.Direction.DESC, "createdDate"))
        query.limit(4)
        query.skip(4*criteria.page)
        mongoOperations.find(query, Child.class)
    }

    @Override
    List<Child> findAll(String id) {
        childRepository.findByPerson_Id(id)
    }

    @Transactional
    @Override
    Child updateSuggestedChild(String l, List<uids> uidses) {
        List<Child> children = findAllByUid(uidses*.uid)
        Child child = findOne(l)
        children.findAll {
            !Contains(child.suggestedChild*.suggested.toSet(), it)
        }.each {
            child.suggestedChild << suggestedChildRepository.save(new SuggestedChild(confidence: uidses.find { u -> u.uid == it.uid }.confidence, suggested: it, child: child))
        }
        childRepository.save(child)
    }


    @Override
    void uplode(Child child) {
        if (child.file && !child.file.isEmpty()) {
            child.image = cloudinaryService.uplode(child.file)
            Child saveChild = save(child)
            def de = skybiometry.detect(child.image, "all")
            if (de.status == status.success) {
                if (de.photos.size() == 1) {
                    def photos = de.photos.get(0);
                    if (photos.tags.size() == 1) {
                        def tags = photos.tags.get(0)
                        def uid = String.valueOf(saveChild.id + "@revo")
                        def save = skybiometry.save(uid, tags.tid)
                        if (save.status == status.success) {
                            skybiometry.train(uid)
                            addUid(saveChild.id, uid)
                        } else throw new Exception("some error happen caused me to unable to save it to the skybiometry server")
                    } else throw new Exception("i need only one tag in this photo to continue")
                } else throw new Exception("i need only one image to continue")
            } else throw new Exception("cant detect image")

        } else throw new Exception("some error in this file please uplode another one ")

    }

    @Override
    Set<SuggestedChild> search(Child c) {
        Child child = findOne(c.id)
        String AllUid = findAll().findAll {
            it.uid != null && it.id != c.id
        }.collect {
            it.uid
        }.join(",")
        def reco = skybiometry.recognize(AllUid, child.image)
        List<uids> uuids = []
        reco.photos.each {
            it.tags.each {
                uuids.addAll(it.uids)
            }
        }
        updateSuggestedChild(c.id, uuids).suggestedChild
    }

    private static boolean Contains(Set<Child> data, Child one) {
        data.any {
            it.id == one.id
        }
    }

}
