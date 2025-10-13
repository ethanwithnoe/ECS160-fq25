package com.ecs160.hw.util;

import java.io.IOException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class GitRepoFetcher {

    private static final String BASE_URL = "https://api.github.com/search/repositories";
    private final String git_api_key;

    public GitRepoFetcher(String git_api_key) {
        this.git_api_key = git_api_key;
    }


    public String fetchTopRepos(String language, int perPage) throws IOException {
        String url = String.format("%s?q=language:%s+fork:true&sort=stars&order=desc&per_page=%d",
                BASE_URL, language, perPage);

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            request.setHeader("Accept", "application/vnd.github+json");
            request.setHeader("Authorization", "Bearer " + git_api_key);
            request.setHeader("X-GitHub-Api-Version", "2022-11-28");

            try (ClassicHttpResponse response = client.executeOpen(null, request, null)) {
                int status = response.getCode();
                if (status != 200) {
                    throw new IOException("Error: HTTP " + status);
                }
                try {
                    return EntityUtils.toString(response.getEntity());
                } catch (org.apache.hc.core5.http.ParseException e) {
                    throw new IOException("Failed to parse response", e);
                }
            }
        }
    }
}
