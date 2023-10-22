package com.squadsync.squadsync;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class EnvironmentConfig {

    @Bean
    public Dotenv dotenv() {
        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.configure().load();

        // Access environment variables
        String dbHost = dotenv.get("DB_HOST");
        String dbPort = dotenv.get("DB_PORT");
        String dbName = dotenv.get("DB_NAME");
        String dbUsername = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");

        // Use these variables in your application's configuration

        return dotenv;
    }
}


