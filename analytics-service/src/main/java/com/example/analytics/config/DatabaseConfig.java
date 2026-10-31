package com.example.analytics.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {
    @Bean
    CommandLineRunner initializeDatabase(JdbcTemplate jdbc) {
        return args -> jdbc.execute(
            "CREATE TABLE IF NOT EXISTS processed_events (" +
            "event_id VARCHAR(100) PRIMARY KEY, " +
            "event_type VARCHAR(100) NOT NULL, " +
            "user_id VARCHAR(100) NOT NULL, " +
            "content_id VARCHAR(100), device_id VARCHAR(100), " +
            "event_timestamp TIMESTAMPTZ NOT NULL, " +
            "processed_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP)"
        );
    }
}
