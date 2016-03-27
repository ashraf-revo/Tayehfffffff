package org.revo.model;

import java.util.Date;

/**
 * Created by revo on 16/09/15.
 */
public class created {
    private String uid;
    private int training_set_size;
    private Date last_trained;
    private boolean training_in_progress;

    public String getUid() {
        return uid;
    }

    public created setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public int getTraining_set_size() {
        return training_set_size;
    }

    public created setTraining_set_size(int training_set_size) {
        this.training_set_size = training_set_size;
        return this;
    }

    public Date getLast_trained() {
        return last_trained;
    }

    public created setLast_trained(Date last_trained) {
        this.last_trained = last_trained;
        return this;
    }

    public boolean isTraining_in_progress() {
        return training_in_progress;
    }

    public created setTraining_in_progress(boolean training_in_progress) {
        this.training_in_progress = training_in_progress;
        return this;
    }
}
