package org.revo.domain

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonView
import groovy.transform.Canonical
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.URL
import org.revo.Util.RevoView
import org.springframework.data.annotation.Id
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by revo on 3/10/16.
 */
@Canonical(excludes = ["children"])
@Document
class Person {
    @Id
    @JsonView(RevoView.PersonView.class)
    String id
    @JsonView(RevoView.PersonView.class)
    String name
    @Email(message = "not a valid email")
    @JsonView(RevoView.PersonView.class)
    String email
    @JsonView(RevoView.PersonView.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password
    @JsonView(RevoView.PersonView.class)
    String phone
    @URL
    @JsonView(RevoView.PersonView.class)
    String image
    @JsonView(RevoView.PersonView.class)
    String moreInfo
    @JsonView(RevoView.PersonView.class)
    String addresses
    @JsonView(RevoView.PersonView.class)
    Point location
    @DBRef
    @JsonView(RevoView.PersonChild.class)
    Set<Child> children
    @JsonView(RevoView.PersonView.class)
    String queueName
    @JsonView(RevoView.PersonView.class)
    boolean enabled = false
}