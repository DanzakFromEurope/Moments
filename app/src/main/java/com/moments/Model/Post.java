package com.moments.Model;

public class Post {
    private String description;
    private String imageUrl;
    private String postId;
    private String author;

    public Post() {

    }

    public Post(String description, String imageUrl, String postId, String author) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.postId = postId;
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
