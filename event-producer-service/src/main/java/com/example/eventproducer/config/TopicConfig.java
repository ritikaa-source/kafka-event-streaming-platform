package com.example.eventproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
    @Bean
    NewTopic digitalEventsTopic() {
        return new NewTopic("digital.events", 4, (short) 1);
    }
}
