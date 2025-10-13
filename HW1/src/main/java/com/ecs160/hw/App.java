package com.ecs160.hw;

import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.ecs160.hw.util.JsonHandler;
import com.ecs160.hw.model.Repo;
import io.github.cdimascio.dotenv.Dotenv;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Dotenv dotenv = Dotenv.load();
        String token=dotenv.get("github_API_KEY");
        System.out.println("environment variable: " + token);

        /*
        APP PLAN
        TODO for all languages
            get the json string
                for all items in repos
                    pars the repo info
                        go through the repo list of issues 
                            parse the issues into issue object
                            append it to the list in repos
                        do the same for commits 
                            parse the commits into issue object
                            append it to the list in repos
                        OPTIONAL
                            get owner from items
                            add it the class of owners and put it in

         */
        
        String jsonString = "{\"id\":132464395,\"node_id\":\"MDEwOlJlcG9zaXRvcnkxMzI0NjQzOTU=\",\"name\":\"JavaGuide\",\"full_name\":\"Snailclimb/JavaGuide\",\"private\":false,\"owner\":{\"login\":\"Snailclimb\",\"id\":29880145,\"node_id\":\"MDQ6VXNlcjI5ODgwMTQ1\",\"avatar_url\":\"https://avatars.githubusercontent.com/u/29880145?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/Snailclimb\",\"html_url\":\"https://github.com/Snailclimb\",\"followers_url\":\"https://api.github.com/users/Snailclimb/followers\",\"following_url\":\"https://api.github.com/users/Snailclimb/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/Snailclimb/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/Snailclimb/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/Snailclimb/subscriptions\",\"organizations_url\":\"https://api.github.com/users/Snailclimb/orgs\",\"repos_url\":\"https://api.github.com/users/Snailclimb/repos\",\"events_url\":\"https://api.github.com/users/Snailclimb/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/Snailclimb/received_events\",\"type\":\"User\",\"user_view_type\":\"public\",\"site_admin\":false},\"html_url\":\"https://github.com/Snailclimb/JavaGuide\",\"description\":\"「Java学习+面试指南」一份涵盖大部分 Java 程序员所需要掌握的核心知识。准备 Java 面试，首选 JavaGuide！\",\"fork\":false,\"url\":\"https://api.github.com/repos/Snailclimb/JavaGuide\",\"forks_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/forks\",\"keys_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/keys{/key_id}\",\"collaborators_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/collaborators{/collaborator}\",\"teams_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/teams\",\"hooks_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/hooks\",\"issue_events_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/issues/events{/number}\",\"events_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/events\",\"assignees_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/assignees{/user}\",\"branches_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/branches{/branch}\",\"tags_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/tags\",\"blobs_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/git/blobs{/sha}\",\"git_tags_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/git/tags{/sha}\",\"git_refs_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/git/refs{/sha}\",\"trees_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/git/trees{/sha}\",\"statuses_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/statuses/{sha}\",\"languages_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/languages\",\"stargazers_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/stargazers\",\"contributors_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/contributors\",\"subscribers_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/subscribers\",\"subscription_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/subscription\",\"commits_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/commits{/sha}\",\"git_commits_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/git/commits{/sha}\",\"comments_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/comments{/number}\",\"issue_comment_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/issues/comments{/number}\",\"contents_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/contents/{+path}\",\"compare_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/compare/{base}...{head}\",\"merges_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/merges\",\"archive_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/{archive_format}{/ref}\",\"downloads_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/downloads\",\"issues_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/issues{/number}\",\"pulls_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/pulls{/number}\",\"milestones_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/milestones{/number}\",\"notifications_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/notifications{?since,all,participating}\",\"labels_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/labels{/name}\",\"releases_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/releases{/id}\",\"deployments_url\":\"https://api.github.com/repos/Snailclimb/JavaGuide/deployments\",\"created_at\":\"2018-05-07T13:27:00Z\",\"updated_at\":\"2025-10-13T20:15:30Z\",\"pushed_at\":\"2025-10-13T12:18:06Z\",\"git_url\":\"git://github.com/Snailclimb/JavaGuide.git\",\"ssh_url\":\"git@github.com:Snailclimb/JavaGuide.git\",\"clone_url\":\"https://github.com/Snailclimb/JavaGuide.git\",\"svn_url\":\"https://github.com/Snailclimb/JavaGuide\",\"homepage\":\"https://javaguide.cn\",\"size\":177091,\"stargazers_count\":152115,\"watchers_count\":152115,\"language\":\"Java\",\"has_issues\":true,\"has_projects\":true,\"has_downloads\":true,\"has_wiki\":true,\"has_pages\":false,\"has_discussions\":true,\"forks_count\":46013,\"mirror_url\":null,\"archived\":false,\"disabled\":false,\"open_issues_count\":73,\"license\":{\"key\":\"apache-2.0\",\"name\":\"Apache License 2.0\",\"spdx_id\":\"Apache-2.0\",\"url\":\"https://api.github.com/licenses/apache-2.0\",\"node_id\":\"MDc6TGljZW5zZTI=\"},\"allow_forking\":true,\"is_template\":false,\"web_commit_signoff_required\":false,\"topics\":[\"algorithms\",\"interview\",\"java\",\"jvm\",\"mysql\",\"redis\",\"spring\",\"system\",\"system-design\",\"zookeeper\"],\"visibility\":\"public\",\"forks\":46013,\"open_issues\":73,\"watchers\":152115,\"default_branch\":\"main\",\"score\":1}";  
        
        
        JsonHandler j = new JsonHandler();
        Repo r = j.fromJson(jsonString, Repo.class);
        System.out.println(r);
        System.out.println("Forks: " + r.getForks());
        //for evry single repor
        //

        
    }
}
