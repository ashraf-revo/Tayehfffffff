package org.revo.model;

/**
 * Created by revo on 15/09/15.
 */
public class limits {
    private status status;
    private String operation_id;
    private usage usage;

    public limits() {
    }

    public limits(status status) {
        this.status = status;
    }

    public status getStatus() {
        return status;
    }

    public limits setStatus(status status) {
        this.status = status;
        return this;
    }

    public String getOperation_id() {
        return operation_id;
    }

    public limits setOperation_id(String operation_id) {
        this.operation_id = operation_id;
        return this;
    }

    public usage getUsage() {
        return usage;
    }

    public limits setUsage(usage usage) {
        this.usage = usage;
        return this;
    }
}
