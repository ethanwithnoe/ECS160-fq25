package com.ecs160.hw;

import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

        
    }
}
