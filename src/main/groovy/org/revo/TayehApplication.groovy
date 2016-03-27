package org.revo

import org.revo.Repository.PersonRepository
import org.revo.Service.SomeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.hateoas.config.EnableEntityLinks

@EnableMongoAuditing
@EnableEntityLinks
@SpringBootApplication
class TayehApplication implements CommandLineRunner {

    static void main(String[] args) {
        SpringApplication.run TayehApplication, args
    }
    @Autowired
    SomeService someService
    @Autowired
    PersonRepository personRepository

    @Override
    void run(String... strings) throws Exception {
//        if (personRepository.count() == 0) someService.init()
    }
}
