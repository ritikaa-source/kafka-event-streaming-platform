package com.example.monitoring.consumer;
import com.example.monitoring.model.DigitalEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MonitoringConsumer {
    @KafkaListener(topics="digital.events", groupId="monitoring-group")
    public void consume(DigitalEvent event) {
        System.out.printf("MONITOR eventId=%s type=%s user=%s device=%s%n",
            event.eventId(), event.eventType(), event.userId(), event.deviceId());
    }
}
