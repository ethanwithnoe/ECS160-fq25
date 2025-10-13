package com.ecs160.hw.model;

import java.util.ArrayList;
import java.util.List;

public class Repo {
    private String name;
    private Owner owner; 
    private String html_url;
    private int forks;
    private String language;
    private int open_issues_count;
    private List<Repo> forksList;
    private List<Commit> recentCommits;
    private List<Issue> issues;
    private int commitCount; //do we need this we need to calcualte later at some point
    private String commit_html;
    private String issue_html;


    public Repo(String name, String ownerLogin, String html_url, int forks, String language, int openIssuesCount, String commit_html, String issue_html) {
        this.name = name;
        this.owner = new Owner(ownerLogin);
        this.html_url = html_url;
        this.forks = forks;
        this.language = language;
        this.open_issues_count = openIssuesCount;
        this.forksList = new ArrayList<>();
        this.recentCommits = new ArrayList<>(50);
        this.issues = new ArrayList<>(10);
        this.commitCount = 0;
        this.commit_html = commit_html;
        this.issue_html = issue_html;
    }

    public String getName() {
        return name;
    }   
    public String getOwnerLogin() {
        return owner.getLogin();
    }
    public String getHtmlUrl() {
        return html_url;
    }
    public int getForks() {
        return forks;
    }
    public String getLanguage() {
        return language;
    }
    public int getOpenIssuesCount() {
        return open_issues_count;
    }
    public List<Repo> getForksList() {
        return forksList;
    }
    public List<Commit> getRecentCommits() {
        return recentCommits;
    }
    public List<Issue> getIssues() {
        return issues;
    }
    public int getCommitCount() {
        return commitCount;
    }
    public void setCommitCount(int commitCount) {
        this.commitCount = commitCount;
    }       
    public void addFork(Repo fork) {
        this.forksList.add(fork);
    }
    public void addRecentCommit(Commit commit) {
        this.recentCommits.add(commit);
    }
    public void addIssue(Issue issue) {
        this.issues.add(issue);
    }  
    public String getCommitHtml() {
        return commit_html;
    }
    public String getIssueHtml() {
        return issue_html;
    }
    
}
