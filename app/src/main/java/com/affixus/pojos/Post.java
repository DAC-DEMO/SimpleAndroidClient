package com.affixus.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by santosh on 6/3/17.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Post {
    private String id;
    private String post;
    private int like_count;
    private int dislike_count;
    private int superlike_count;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty(value = "POST")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @JsonProperty(value = "LIKE_COUNT")
    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }


    @JsonProperty(value = "DISLIKE_COUNT")
    public int getDislike_count() {
        return dislike_count;
    }

    public void setDislike_count(int dislike_count) {
        this.dislike_count = dislike_count;
    }

    @JsonProperty(value = "SUPERLIKE_COUNT")
    public int getSuperlike_count() {
        return superlike_count;
    }

    public void setSuperlike_count(int superlike_count) {
        this.superlike_count = superlike_count;
    }
}
