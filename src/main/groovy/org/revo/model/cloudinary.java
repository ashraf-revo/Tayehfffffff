package org.revo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

/**
 * Created by revo on 17/11/15.
 */
public class cloudinary {
    @Value("${org.revo.cloudinary.cloud_name}")
    String cloud_name;
    @Value("${org.revo.cloudinary.api_key}")
    String api_key;
    @Value("${org.revo.cloudinary.api_secret}")
    String api_secret;

    public cloudinary() {
    }

    public cloudinary(Environment environment) {
        cloud_name = environment.getProperty("org.revo.cloudinary.cloud_name");
        api_key = environment.getProperty("org.revo.cloudinary.api_key");
        api_secret = environment.getProperty("org.revo.cloudinary.api_secret");

    }

    public String getCloud_name() {
        return cloud_name;
    }

    public cloudinary setCloud_name(String cloud_name) {
        this.cloud_name = cloud_name;
        return this;
    }

    public String getApi_key() {
        return api_key;
    }

    public cloudinary setApi_key(String api_key) {
        this.api_key = api_key;
        return this;
    }

    public String getApi_secret() {
        return api_secret;
    }

    public cloudinary setApi_secret(String api_secret) {
        this.api_secret = api_secret;
        return this;
    }
}
