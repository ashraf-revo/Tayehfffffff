package org.revo.cong


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.mapping.event.LoggingEventListener
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

import javax.validation.Validator

/**
 * Created by revo on 3/12/16.
 */
@Configuration
class SomeConfig {

    @Bean
    public Validator getValidator() {
        new LocalValidatorFactoryBean()
    }

    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener(Validator validator) {
        new ValidatingMongoEventListener(validator)
    }

    @Bean
    LoggingEventListener eventListener() {
        return new LoggingEventListener()
    }
}
