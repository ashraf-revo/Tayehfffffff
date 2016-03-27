package org.revo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by revo on 15/09/15.
 */
public class tags {
    private List<uids> uids;
    private String label;
    private boolean confirmed;
    private boolean manual;
    private float width;
    private float height;
    private int yaw;
    private int roll;
    private int pitch;
    private Map<String, point> attributes = new HashMap<>();
    private String tid;
    private boolean recognizable;
    private point center;
    private point eye_left;
    private point eye_right;
    private point mouth_center;
    private point nose;
    private int threshold;

    public List<uids> getUids() {
        return uids;
    }

    public tags setUids(List<uids> uids) {
        this.uids = uids;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public tags setLabel(String label) {
        this.label = label;
        return this;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public tags setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
        return this;
    }

    public boolean isManual() {
        return manual;
    }

    public tags setManual(boolean manual) {
        this.manual = manual;
        return this;
    }

    public float getWidth() {
        return width;
    }

    public tags setWidth(float width) {
        this.width = width;
        return this;
    }

    public float getHeight() {
        return height;
    }

    public tags setHeight(float height) {
        this.height = height;
        return this;
    }

    public int getYaw() {
        return yaw;
    }

    public tags setYaw(int yaw) {
        this.yaw = yaw;
        return this;
    }

    public int getRoll() {
        return roll;
    }

    public tags setRoll(int roll) {
        this.roll = roll;
        return this;
    }

    public int getPitch() {
        return pitch;
    }

    public tags setPitch(int pitch) {
        this.pitch = pitch;
        return this;
    }

    public Map<String, point> getAttributes() {
        return attributes;
    }

    public tags setAttributes(Map<String, point> attributes) {
        this.attributes = attributes;
        return this;
    }

    public String getTid() {
        return tid;
    }

    public tags setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public boolean isRecognizable() {
        return recognizable;
    }

    public tags setRecognizable(boolean recognizable) {
        this.recognizable = recognizable;
        return this;
    }

    public point getCenter() {
        return center;
    }

    public tags setCenter(point center) {
        this.center = center;
        return this;
    }

    public point getEye_left() {
        return eye_left;
    }

    public tags setEye_left(point eye_left) {
        this.eye_left = eye_left;
        return this;
    }

    public point getEye_right() {
        return eye_right;
    }

    public tags setEye_right(point eye_right) {
        this.eye_right = eye_right;
        return this;
    }

    public point getMouth_center() {
        return mouth_center;
    }

    public tags setMouth_center(point mouth_center) {
        this.mouth_center = mouth_center;
        return this;
    }

    public point getNose() {
        return nose;
    }

    public tags setNose(point nose) {
        this.nose = nose;
        return this;
    }

    public int getThreshold() {
        return threshold;
    }

    public tags setThreshold(int threshold) {
        this.threshold = threshold;
        return this;
    }
}
