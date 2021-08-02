package com.example.lab5_networking.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Value implements Serializable{
    @SerializedName("url")
    private String url;

    @SerializedName("height")
    private Integer height;

    @SerializedName("witdh")
    private Integer witdh;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("thumbnailHeight")
    private String thumbnailHeight;

    @SerializedName("thumbnailWidth")
    private String thumbnailWidth;

    @SerializedName("name")
    private String name;

    @SerializedName("title")
    private String title;

    @SerializedName("imageWebSearchUrl")
    private String imageWebSearchUrl;

    @SerializedName("webpageUrl")
    private String webpageUrl;

    public Value(String url, Integer height, Integer witdh, String thumbnail, String thumbnailHeight, String thumbnailWidth, String name, String title, String imageWebSearchUrl, String webpageUrl) {
        this.url = url;
        this.height = height;
        this.witdh = witdh;
        this.thumbnail = thumbnail;
        this.thumbnailHeight = thumbnailHeight;
        this.thumbnailWidth = thumbnailWidth;
        this.name = name;
        this.title = title;
        this.imageWebSearchUrl = imageWebSearchUrl;
        this.webpageUrl = webpageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWitdh() {
        return witdh;
    }

    public void setWitdh(Integer witdh) {
        this.witdh = witdh;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(String thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public String getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(String thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageWebSearchUrl() {
        return imageWebSearchUrl;
    }

    public void setImageWebSearchUrl(String imageWebSearchUrl) {
        this.imageWebSearchUrl = imageWebSearchUrl;
    }

    public String getWebpageUrl() {
        return webpageUrl;
    }

    public void setWebpageUrl(String webpageUrl) {
        this.webpageUrl = webpageUrl;
    }

}
