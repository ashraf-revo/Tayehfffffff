package org.revo.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.JsonView
import groovy.transform.Canonical
import org.hibernate.validator.constraints.URL
import org.revo.domain.RevoEnum.Gender
import org.revo.domain.RevoEnum.State
import org.revo.Util.RevoView
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by revo on 3/10/16.
 */
@Canonical(excludes = ["suggestedChild","person"])
@Document
class Child {
    @Id
    @JsonView(RevoView.ChildView.class)
    String id
    @JsonView(RevoView.ChildView.class)
    String name
    @URL
    @JsonView(RevoView.ChildView.class)
    String image
    @JsonView(RevoView.ChildView.class)
    String moreInfo
    @JsonView(RevoView.ChildView.class)
    Point addresses
    @DBRef
    @JsonView(RevoView.ChildPerson.class)
    Person person
    @JsonView(RevoView.ChildView.class)
    State state
    @DBRef
    @JsonView(RevoView.ChildSuggested.class)
    Set<SuggestedChild> suggestedChild = new HashSet<>()
    @JsonView(RevoView.ChildView.class)
    Gender gender
    @JsonView(RevoView.ChildView.class)
    int age
    @JsonView(RevoView.ChildView.class)
    String uid
    @JsonView(RevoView.ChildView.class)
    boolean founded
    @CreatedDate
    @JsonView(RevoView.ChildView.class)
    Date createdDate
    @Transient
    String file
}