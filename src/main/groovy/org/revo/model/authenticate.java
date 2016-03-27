package org.revo.model;

/**
 * Created by revo on 15/09/15.
 */
public class authenticate {
    private status status;
    private String operation_id;
    private boolean authenticated;

    public authenticate(status status, boolean authenticated) {
        this.status = status;
        this.authenticated = authenticated;
    }

    public authenticate() {
    }

    public status getStatus() {
        return status;
    }

    public authenticate setStatus(status status) {
        this.status = status;
        return this;
    }

    public boolean getAuthenticated() {
        return authenticated;
    }

    public authenticate setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
        return this;
    }

    public String getOperation_id() {
        return operation_id;
    }

    public authenticate setOperation_id(String operation_id) {
        this.operation_id = operation_id;
        return this;
    }

    @Override
    public String toString() {
        return status + "  " + authenticated;
    }
}
