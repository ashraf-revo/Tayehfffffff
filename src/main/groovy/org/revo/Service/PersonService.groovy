package org.revo.Service

import org.revo.domain.Child
import org.revo.domain.Person

/**
 * Created by ashraf on 2/5/2016.
 */
interface PersonService {
    Person findCurrent();

    void addChild(Person person, Child child)
}