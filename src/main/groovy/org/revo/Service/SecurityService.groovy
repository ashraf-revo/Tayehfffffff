package org.revo.Service

import org.revo.model.RevoUser
import org.springframework.web.context.request.WebRequest

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse;


/**
 * Created by revo on 05/12/15.
 */
interface SecurityService {
    RevoUser GetRevoUser() throws Exception
    void handelSocialSignUp(WebRequest request, HttpServletRequest req, HttpServletResponse res);
}
