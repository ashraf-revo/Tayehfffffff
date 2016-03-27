package org.revo.Service.impl

import org.revo.Repository.PersonRepository
import org.revo.Service.PersonService
import org.revo.Service.SecurityService
import org.revo.domain.Child
import org.revo.domain.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service

import static org.springframework.data.mongodb.core.query.Criteria.where

/**
 * Created by ashraf on 2/5/2016.
 */
@Service
class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository
    @Autowired
    MongoOperations mongoOperations
    @Autowired
    SecurityService securityService

    @Override
    Person findCurrent() {
        return personRepository.findOne(securityService.GetRevoUser().id);
    }

    @Override
    void addChild(Person person, Child child) {
        Query query = new Query()
        query.addCriteria(where("id").is(person.id))
        Update update = new Update()
        update.addToSet("children", child)
        mongoOperations.updateFirst(query, update, Person.class)
    }
}
