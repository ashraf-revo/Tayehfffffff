package org.revo.model;

/**
 * Created by revo on 15/09/15.
 */
public class point {
    private int id;
    private float x;
    private float y;
    private int confidence;

    public int getId() {
        return id;
    }

    public point setId(int id) {
        this.id = id;
        return this;
    }

    public float getX() {
        return x;
    }

    public point setX(float x) {
        this.x = x;
        return this;
    }

    public float getY() {
        return y;
    }

    public point setY(float y) {
        this.y = y;
        return this;
    }

    public int getConfidence() {
        return confidence;
    }

    public point setConfidence(int confidence) {
        this.confidence = confidence;
        return this;
    }
}
