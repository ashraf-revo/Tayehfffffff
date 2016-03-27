package org.revo.Service.impl

import org.revo.Service.MailService
import org.revo.domain.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring4.SpringTemplateEngine

import javax.mail.internet.MimeMessage

/**
 * Created by ashraf on 1/27/2016.
 */
@Service
class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    @Override
    void Send(String to, String subject, String text, boolean isHtml) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, isHtml);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        javaMailSender.send(message);
    }

    @Override
    void SendActivation(Person person, String Password) {
        Context context = new Context();
        context.setVariable("name", person.email)
        context.setVariable("password", Password)
        Send(person.email, "Activation Message", templateEngine.process("activationEmail", context), true)
    }
}
