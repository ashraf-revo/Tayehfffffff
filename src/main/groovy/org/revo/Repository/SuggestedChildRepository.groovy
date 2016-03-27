package org.revo.Repository

import org.revo.domain.SuggestedChild
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * Created by revo on 3/10/16.
 */
@RepositoryRestResource
interface SuggestedChildRepository extends MongoRepository<SuggestedChild, String>{

}