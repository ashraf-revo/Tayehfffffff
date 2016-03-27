package org.revo.model;

/**
 * Created by revo on 15/09/15.
 */
public class saved_tags {
    private String tid;
    private String detected_tid;

    public String getTid() {
        return tid;
    }

    public saved_tags setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getDetected_tid() {
        return detected_tid;
    }

    public saved_tags setDetected_tid(String detected_tid) {
        this.detected_tid = detected_tid;
        return this;
    }
}
