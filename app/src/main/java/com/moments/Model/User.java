package com.moments.Model;

public class User {
    private String email;
    private String username;
    private String bio;
    private String profileImageUrl;
    private String id;

    public User() {
    }

    public User(String email, String username, String bio, String imageurl, String id) {
        this.email = email;
        this.username = username;
        this.bio = bio;
        this.profileImageUrl = imageurl;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return profileImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.profileImageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
