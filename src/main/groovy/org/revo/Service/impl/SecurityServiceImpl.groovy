package org.revo.Service.impl

import org.revo.Repository.PersonRepository
import org.revo.Service.MailService
import org.revo.Service.SecurityService
import org.revo.domain.Person
import org.revo.model.RevoUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.RememberMeServices
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler
import org.springframework.social.connect.Connection
import org.springframework.social.connect.UserProfile
import org.springframework.social.connect.web.ProviderSignInUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.request.WebRequest

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by revo on 05/12/15.
 */
@Service
@Transactional
class SecurityServiceImpl implements SecurityService {
    @Autowired
    PasswordEncoder encoder
    @Autowired
    ProviderSignInUtils signInUtils
    @Autowired
    RememberMeServices services
    @Autowired
    PersonRepository personRepository

    RevoUser GetRevoUser() throws Exception {
        Authentication authentication = SecurityContextHolder.context.authentication
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof RevoUser) {
                return authentication.principal as RevoUser
            } else {
                throw new Exception("not login user")
            }
        } else throw new Exception("not login user")
    }
    @Autowired
    MailService mailService

    @Override
    void handelSocialSignUp(WebRequest request, HttpServletRequest req, HttpServletResponse res) {
        Connection<?> connectionFromSession = signInUtils.getConnectionFromSession(request)
        if (connectionFromSession != null) {
            UserProfile userProfile = connectionFromSession.fetchUserProfile()
            Person u = personRepository.findByEmail(userProfile.getEmail())
                    .map { it }
                    .orElseGet {
                String queueName = UUID.randomUUID().toString().replace("-", "").subSequence(0, 12).toString()
//                CreateQueueFor(queueName);
                def password = UUID.randomUUID().toString()
                def save = personRepository.save(new Person(email: userProfile.email,
                        password: encoder.encode(password),
                        image: connectionFromSession.imageUrl,
                        name: userProfile.firstName + " " + userProfile.lastName,
                        queueName: queueName))
                mailService.SendActivation(save, password)
                save
            }
            Authentication authentication = new UsernamePasswordAuthenticationToken(u.email, u.password, [new SimpleGrantedAuthority("ROLE_USER")])
            Authentication auth = SecurityContextHolder.context.authentication
            if (auth != null) {
                new SecurityContextLogoutHandler().logout(req, res, auth)
                SecurityContextHolder.context.authentication = authentication
            }
            signInUtils.doPostSignUp(userProfile.getEmail(), request)
            services.loginSuccess(req, res, authentication)
        }
    }
}