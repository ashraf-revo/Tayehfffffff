package org.revo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by revo on 15/09/15.
 */
public class photos {
    private String url;
    private String pid;
    private float width;
    private float height;
    private List<tags> tags = new ArrayList<>();

    public String getUrl() {
        return url;
    }

    public photos setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPid() {
        return pid;
    }

    public photos setPid(String pid) {
        this.pid = pid;
        return this;
    }

    public float getWidth() {
        return width;
    }

    public photos setWidth(float width) {
        this.width = width;
        return this;
    }

    public float getHeight() {
        return height;
    }

    public photos setHeight(float height) {
        this.height = height;
        return this;
    }

    public List<tags> getTags() {
        return tags;
    }

    public photos setTags(List<tags> tags) {
        this.tags = tags;
        return this;
    }
}
