package org.revo.model;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by ashraf on 9/14/2015.
 */
public class login {
    @Value("${org.revo.Skybiometry.api_key}")
    private String api_key;
    @Value("${org.revo.Skybiometry.api_secret}")
    private String api_secret;
    @Value("${org.revo.Skybiometry.namespace}")
    private String namespace;

    public login() {
    }

    public login(String api_key, String api_secret, String namespace) {
        this.api_key = api_key;
        this.api_secret = api_secret;
        this.namespace = namespace;
    }

    public String getApi_key() {
        return api_key;
    }

    public login setApi_key(String api_key) {
        this.api_key = api_key;
        return this;
    }

    public String getApi_secret() {
        return api_secret;
    }

    public login setApi_secret(String api_secret) {
        this.api_secret = api_secret;
        return this;
    }

    public String getNamespace() {
        return namespace;
    }

    public login setNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    @Override
    public String toString() {
        return "api_key=" + api_key + "&api_secret=" + api_secret;
    }

}
