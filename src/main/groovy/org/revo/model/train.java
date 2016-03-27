package org.revo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by revo on 16/09/15.
 */
public class train {
    private status status;
    private String operation_id;
    private usage usage;
    @JsonProperty("unchanged")
    private List<created> created;

    public train() {
    }

    public train(status status) {
        this.status = status;
    }

    public status getStatus() {
        return status;
    }

    public train setStatus(status status) {
        this.status = status;
        return this;
    }

    public String getOperation_id() {
        return operation_id;
    }

    public train setOperation_id(String operation_id) {
        this.operation_id = operation_id;
        return this;
    }

    public usage getUsage() {
        return usage;
    }

    public train setUsage(usage usage) {
        this.usage = usage;
        return this;
    }

    public List<created> getCreated() {
        return created;
    }

    public train setCreated(List<created> created) {
        this.created = created;
        return this;
    }
}
