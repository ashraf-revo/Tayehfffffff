package org.revo.controller

import org.revo.Service.SecurityService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.context.request.WebRequest

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by revo on 21/10/15.
 */
@Controller
class MainCtrl {
    @Autowired
    SecurityService securityService
    private final static Logger logger = LoggerFactory.getLogger(MainCtrl.class)

    @RequestMapping(value = "/signup")
    String signup(WebRequest request, HttpServletRequest req, HttpServletResponse res) {
        securityService.handelSocialSignUp(request, req, res)
        return "redirect:/"
    }
}
