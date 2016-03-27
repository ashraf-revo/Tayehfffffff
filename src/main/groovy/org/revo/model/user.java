package org.revo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by revo on 15/09/15.
 */
public class user {
    private status status;
    private String operation_id;
    @JsonProperty
    private Map<String, List<String>> users;

    public user() {
    }

    public user(status status) {
        this.status = status;
    }

    public status getStatus() {
        return status;
    }

    public user setStatus(status status) {
        this.status = status;
        return this;
    }

    public String getOperation_id() {
        return operation_id;
    }

    public user setOperation_id(String operation_id) {
        this.operation_id = operation_id;
        return this;
    }


    public Map<String, List<String>> getUsers() {
        return users;
    }

    public user setUsers(Map<String, List<String>> users) {
        this.users = users;
        return this;
    }
}
