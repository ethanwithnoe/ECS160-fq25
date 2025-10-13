package com.ecs160.hw.model;

public class Owner {
    private String login;
    private int id;
    private String html_url;
    private boolean siteAdmin;
    
    public Owner(String login) {
        this.login = login;
    }
        
    public Owner(String login, int id, String html_url, boolean siteAdmin) {
        this.login = login;
        this.id = id;
        this.html_url = html_url;
        this.siteAdmin = siteAdmin;
    }
    public String getLogin() {
        return login;
    }
    public int getId() {
        return id;
    }
    public String getHtmlUrl() {
        return html_url;
    }
    public boolean isSiteAdmin() {
        return siteAdmin;
    }
}

