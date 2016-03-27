package org.revo.cong;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.revo.Service.impl.SkybiometryImpl;
import org.revo.model.login;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by revo on 20/10/15.
 */
@Configuration
class Skybiometryconfg {
    @Bean
    login login() {
        return new login();
    }

    @Bean
    Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dmmcfa9c0",
                "api_key", "553119935255391",
                "api_secret", "pkKIFJyAhX5xmQWVadko4VaCDi4"));
    }

    @Bean
    SkybiometryImpl skybiometry() {
        return new SkybiometryImpl();
    }
}
