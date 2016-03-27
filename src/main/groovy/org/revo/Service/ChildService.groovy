package org.revo.Service

import org.revo.domain.Child
import org.revo.domain.SuggestedChild
import org.revo.model.SearchCriteria
import org.revo.model.uids

/**
 * Created by ashraf on 2/5/2016.
 */
interface ChildService {
    Child save(Child child)

    Child addUid(String id, String uid)

    Child findOne(String id)

    List<Child> findAllByUid(List<String> uuid)

    List<Child> findAll()

    List<Child> search(SearchCriteria criteria)

    List<Child> findAll(String id)

    Child updateSuggestedChild(String l, List<uids> uidses)

    void uplode(Child child)

    Set<SuggestedChild> search(Child c)
}