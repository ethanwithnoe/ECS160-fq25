package com.ecs160.hw.model;

public class Issue {

    private String title;
    private String body;
    private String state;
    private String createdAt;
    private String updatedAt;

    public Issue(String title, String body, String state, String createdAt, String updatedAt) {
        this.title = title;
        this.body = body;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public String getState() {
        return state;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }

}
