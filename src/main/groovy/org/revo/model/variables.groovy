package org.revo.model

import groovy.transform.Canonical
import org.springframework.core.env.Environment

/**
 * Created by revo on 17/11/15.
 */
@Canonical
class variables {
    String queuename
    String virtual_host
    String host
    String username
    String password
    def cloudinary

    variables(String qn, Environment env) {
        this.queuename = qn
        virtual_host = env.getProperty("spring.rabbitmq.virtual-host")
        host = env.getProperty("spring.rabbitmq.host")
        username = env.getProperty("spring.rabbitmq.username")
        password = env.getProperty("spring.rabbitmq.password")
        cloudinary = new cloudinary(env)
    }
}
