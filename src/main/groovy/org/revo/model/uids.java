package org.revo.model;

/**
 * Created by revo on 16/09/15.
 */
public class uids {
    private String uid;
    private int confidence;

    public String getUid() {
        return uid;
    }

    public uids setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public int getConfidence() {
        return confidence;
    }

    public uids setConfidence(int confidence) {
        this.confidence = confidence;
        return this;
    }
}
