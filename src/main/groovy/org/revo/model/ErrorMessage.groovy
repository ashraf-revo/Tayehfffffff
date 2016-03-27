package org.revo.model

import groovy.transform.Canonical

/**
 * Created by revo on 23/01/16.
 */
@Canonical
class ErrorMessage {
    Long Mid
    String Message
    Long Uid
    Set<String> authorities

    ErrorMessage(Long Mid, String message) {
        this.Mid = Mid
        Message = message
    }

    ErrorMessage users(RevoUser revoUser) {
        this.Uid = revoUser.id
        authorities = revoUser.authorities.collect {
            it.authority
        }
        this
    }
}
