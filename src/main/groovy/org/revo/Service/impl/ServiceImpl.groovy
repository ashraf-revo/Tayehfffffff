package org.revo.Service.impl

import org.revo.Repository.ChildRepository
import org.revo.Repository.PersonRepository
import org.revo.Service.SomeService
import org.revo.domain.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import javax.persistence.PersistenceContext

/**
 * Created by ashraf on 2/5/2016.
 */
@Service
@Transactional
public class ServiceImpl implements SomeService {
    @Autowired
    PersonRepository p;
    @Autowired
    ChildRepository childRepository;

    @PersistenceContext
    @Override
    public void init() {
        def person = new Person(name: "ashraf1", password: new BCryptPasswordEncoder().encode("ashraf1"), email: "ashraf11@saa.com", phone: "012345671", queueName: "ashraf1")
//        def person1 = new Person(name: "ashraf2", password: new BCryptPasswordEncoder().encode("ashraf2"), email: "ashraf12@saa.com", phone: "012345671",queueName: "ashraf2")
//        def person2 = new Person(name: "ashraf3", password: new BCryptPasswordEncoder().encode("ashraf3"), email: "ashraf13@saa.com", phone: "012345673",queueName: "ashraf3")
        p.save(person)
//        p.save(person1)
//        p.save(person2)

//        def one = p.findOne(1 as Long)
//        def child1 = new Child(person: one, name: "a1", state: false, gender: true, age: 15, founded: false)
//        def child2 = new Child(person: one, name: "a2", state: true, gender: true, age: 15, founded: false)
//        def child3 = new Child(person: one, name: "a3", state: true, gender: true, age: 15, founded: true)
//        childRepository.save(child1)
//        childRepository.save(child2)
//        childRepository.save(child3)

//        typedQuery.setParameter("founded", false)
//        typedQuery.setParameter("age1", 15)
//        typedQuery.setParameter("age2", 15)
//        typedQuery.setParameter("location", "ques")
//        typedQuery.resultList.each {
//            println(it.name)
//        }
    }
}
