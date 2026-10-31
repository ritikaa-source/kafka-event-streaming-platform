package com.example.analytics.consumer;

import com.example.analytics.model.DigitalEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsConsumer {
    private final JdbcTemplate jdbc;
    public AnalyticsConsumer(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    @KafkaListener(topics="digital.events", groupId="analytics-group")
    public void consume(DigitalEvent event) {
        int inserted = jdbc.update(
            "INSERT INTO processed_events " +
            "(event_id,event_type,user_id,content_id,device_id,event_timestamp) VALUES (?,?,?,?,?,?) " +
            "ON CONFLICT (event_id) DO NOTHING",
            event.eventId(), event.eventType(), event.userId(),
            event.contentId(), event.deviceId(), event.timestamp());
        System.out.println(inserted == 0
            ? "Duplicate ignored: " + event.eventId()
            : "Analytics processed: " + event.eventId());
    }
}
