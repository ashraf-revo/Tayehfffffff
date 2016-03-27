package org.revo.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.revo.domain.Person
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.social.security.SocialUser

/**
 * Created by ashraf on 2/4/2016.
 */
@JsonIgnoreProperties(["id", "password", "authorities", "accountNonExpired", "accountNonLocked", "credentialsNonExpired", "enabled"])
class RevoUser extends SocialUser {
    String id
    String email
    String image
    List<String> roles = ["ROLE_USER"]

    RevoUser(Person person) {
        super(person.email, person.password, AuthorityUtils.createAuthorityList("ROLE_USER"))
        this.id = person.id
        this.email = person.email
        this.image = person.image;
    }
}
