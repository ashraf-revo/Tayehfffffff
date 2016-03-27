package org.revo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by revo on 16/09/15.
 */
public class recognize {
    private status status;
    private String operation_id;
    private usage usage;
    private List<photos> photos = new ArrayList<>();

    public recognize() {
    }

    public recognize(status status) {
        this.status = status;
    }

    public status getStatus() {
        return status;
    }

    public recognize setStatus(status status) {
        this.status = status;
        return this;
    }

    public String getOperation_id() {
        return operation_id;
    }

    public recognize setOperation_id(String operation_id) {
        this.operation_id = operation_id;
        return this;
    }

    public usage getUsage() {
        return usage;
    }

    public recognize setUsage(usage usage) {
        this.usage = usage;
        return this;
    }

    public List<photos> getPhotos() {
        return photos;
    }

    public recognize setPhotos(List<photos> photos) {
        this.photos = photos;
        return this;
    }
}
