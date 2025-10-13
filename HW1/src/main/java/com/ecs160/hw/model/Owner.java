package com.ecs160.hw.model;

public class Owner {
    private String login;
    private int id;
    private String htmlUrl;
    private boolean siteAdmin;
    public Owner(String login, int id, String htmlUrl, boolean siteAdmin) {
        this.login = login;
        this.id = id;
        this.htmlUrl = htmlUrl;
        this.siteAdmin = siteAdmin;
    }
    public String getLogin() {
        return login;
    }
    public int getId() {
        return id;
    }
    public String getHtmlUrl() {
        return htmlUrl;
    }
    public boolean isSiteAdmin() {
        return siteAdmin;
    }
}

