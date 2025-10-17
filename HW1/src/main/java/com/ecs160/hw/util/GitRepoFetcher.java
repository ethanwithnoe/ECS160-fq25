package com.ecs160.hw.util;

import java.io.IOException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class GitRepoFetcher {

    private static final String BASE_URL = "https://api.github.com/search/repositories";
    private final String git_api_key;
    private static final Gson gson = new Gson(); 

    public GitRepoFetcher(String git_api_key) {
        this.git_api_key = git_api_key; // personal API passed during initialization
    }


    // returns raw json string of top repos for a given language
    public String fetchTopRepos(String language, int perPage) throws IOException {
        String url = String.format("%s?q=language:%s+fork:true&sort=stars&order=desc&per_page=%d",
                BASE_URL, language, perPage); //specify language and number of repos to fetch

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
                try { // 
                    String raw_json_string = EntityUtils.toString(response.getEntity()); //raw repo data
                    String items_key = extractItems(raw_json_string);
                    return items_key;

                } catch (org.apache.hc.core5.http.ParseException e) {
                    throw new IOException("Failed to parse response", e);
                }
            }
        }
    }

    
    // extracts json values from items key
    public String extractItems(String json) {
        JsonElement root = gson.fromJson(json, JsonElement.class); //convert string to a JsonElement
        JsonObject obj = root.getAsJsonObject(); //convert JsonElement to JsonObject

        if (!obj.has("items")) { //validate json contains items key
            throw new IllegalArgumentException("JSON does not contain key 'items'");
        }

        JsonArray items = obj.getAsJsonArray("items");
        return gson.toJson(items);  // return as a JSON-formatted string
    }


}
