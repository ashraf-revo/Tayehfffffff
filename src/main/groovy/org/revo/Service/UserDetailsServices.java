package org.revo.Service;

import org.revo.Repository.PersonRepository;
import org.revo.model.RevoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by revo on 22/10/15.
 */
@Service
@Transactional
class UserDetailsServices implements UserDetailsService, SocialUserDetailsService {
    @Autowired
    PersonRepository personRepository;


    RevoUser loadRevoUser(String loader) throws UsernameNotFoundException {
        return personRepository.findByEmail(loader).map(RevoUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("cant find this one"));
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        return loadRevoUser(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadRevoUser(username);
    }
}
