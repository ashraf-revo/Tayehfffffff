package org.revo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by revo on 15/09/15.
 */
public class save {
    private status status;
    private String operation_id;
    private List<saved_tags> saved_tags = new ArrayList<>();
    private String message;

    public save(status status) {
        this.status = status;
    }

    public save() {
    }

    public status getStatus() {
        return status;
    }

    public save setStatus(status status) {
        this.status = status;
        return this;
    }

    public String getOperation_id() {
        return operation_id;
    }

    public save setOperation_id(String operation_id) {
        this.operation_id = operation_id;
        return this;
    }

    public List<saved_tags> getSaved_tags() {
        return saved_tags;
    }

    public save setSaved_tags(List<saved_tags> saved_tags) {
        this.saved_tags = saved_tags;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public save setMessage(String message) {
        this.message = message;
        return this;
    }
}
