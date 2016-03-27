package org.revo.Repository

import org.revo.domain.Child
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * Created by revo on 3/10/16.
 */
@RepositoryRestResource
interface ChildRepository extends MongoRepository<Child, String> {
    List<Child> findByPerson_Id(String id);

    List<Child> findByUidIn(List<String> uids);
}