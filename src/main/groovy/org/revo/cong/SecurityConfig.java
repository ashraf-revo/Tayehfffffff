package org.revo.cong;

import org.revo.cong.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created by ashraf on 8/2/15.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetails;
    private String key = "revo_Key";
    @Autowired
    private AjaxAuthenticationSuccessHandler Success;
    @Autowired
    private AjaxAuthenticationFailureHandler Failure;
    @Autowired
    private AjaxLogoutSuccessHandler Logout;
    @Autowired
    private Http401UnauthorizedEntryPoint EntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new CsrfCookieGeneratorFilter(), CsrfFilter.class)
                .exceptionHandling().authenticationEntryPoint(EntryPoint)
                .and().rememberMe().rememberMeServices(rememberMeServices()).key(key)
                .and().formLogin().loginProcessingUrl("/api/authentication").successHandler(Success).failureHandler(Failure).usernameParameter("j_username").passwordParameter("j_password").permitAll()
                .and().logout().logoutUrl("/api/logout").logoutSuccessHandler(Logout).deleteCookies("JSESSIONID", "CSRF-TOKEN").permitAll()
                .and().authorizeRequests()
                .antMatchers("/api/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/api/home/**").hasRole("USER")
                .antMatchers("/api/*").permitAll()
                .and().apply(new SpringSocialConfigurer())
                .and().headers().frameOptions().sameOrigin()
//        .and().csrf().disable()
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RememberMeServices rememberMeServices() {
        TokenBasedRememberMeServices tokenBasedRememberMeServices = new TokenBasedRememberMeServices(key, userDetailsService());
        tokenBasedRememberMeServices.setAlwaysRemember(true);
        return tokenBasedRememberMeServices;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }
}