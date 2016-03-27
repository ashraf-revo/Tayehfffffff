package org.revo.Service

import org.revo.domain.Person
import org.springframework.scheduling.annotation.Async

/**
 * Created by ashraf on 1/27/2016.
 */
interface MailService {
    @Async
    void Send(String to, String subject, String text, boolean isHtml)

    @Async
    void SendActivation(Person person, String Password)

}