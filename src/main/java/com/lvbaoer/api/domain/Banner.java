package com.lvbaoer.api.domain;

import java.io.Serializable;

public class Banner implements Serializable {
    private static final long serialVersionUID = 1235147256089587969L;
    private int id;
    private String title;
    private String image;
    private String url;

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        this.title = title;
    }

    public final String getImage() {
        return image;
    }

    public final void setImage(String image) {
        this.image = image;
    }

    public final String getUrl() {
        return url;
    }

    public final void setUrl(String url) {
        this.url = url;
    }

}
