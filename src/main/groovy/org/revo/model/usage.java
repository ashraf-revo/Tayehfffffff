package org.revo.model;

import java.util.Date;

public class usage {
    private int used;
    private int remaining;
    private int limit;
    private Date reset_time;
    private Date reset_time_text;
    private int namespace_used;
    private int namespace_remaining;
    private int namespace_limit;

    public usage() {
    }

    public int getUsed() {
        return used;
    }

    public usage setUsed(int used) {
        this.used = used;
        return this;
    }

    public int getRemaining() {
        return remaining;
    }

    public usage setRemaining(int remaining) {
        this.remaining = remaining;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public usage setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public Date getReset_time() {
        return reset_time;
    }

    public usage setReset_time(Date reset_time) {
        this.reset_time = reset_time;
        return this;
    }

    public Date getReset_time_text() {
        return reset_time_text;
    }

    public usage setReset_time_text(Date reset_time_text) {
        this.reset_time_text = reset_time_text;
        return this;
    }

    public int getNamespace_used() {
        return namespace_used;
    }

    public usage setNamespace_used(int namespace_used) {
        this.namespace_used = namespace_used;
        return this;
    }

    public int getNamespace_remaining() {
        return namespace_remaining;
    }

    public usage setNamespace_remaining(int namespace_remaining) {
        this.namespace_remaining = namespace_remaining;
        return this;
    }

    public int getNamespace_limit() {
        return namespace_limit;
    }

    public usage setNamespace_limit(int namespace_limit) {
        this.namespace_limit = namespace_limit;
        return this;
    }
}
