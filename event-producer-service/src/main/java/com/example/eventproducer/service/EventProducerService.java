package com.example.eventproducer.service;

import com.example.eventproducer.model.DigitalEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducerService {
    private static final String TOPIC = "digital.events";
    private final KafkaTemplate<String, DigitalEvent> kafkaTemplate;

    public EventProducerService(KafkaTemplate<String, DigitalEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(DigitalEvent event) {
        kafkaTemplate.send(TOPIC, event.userId(), event);
    }
}
