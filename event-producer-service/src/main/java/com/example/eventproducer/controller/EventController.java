package com.example.eventproducer.controller;

import com.example.eventproducer.model.DigitalEvent;
import com.example.eventproducer.service.EventProducerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventProducerService eventProducerService;

    public EventController(EventProducerService eventProducerService) {
        this.eventProducerService = eventProducerService;
    }

    @PostMapping
    public ResponseEntity<String> publishEvent(@Valid @RequestBody DigitalEvent event) {
        eventProducerService.publish(event);
        return ResponseEntity.accepted().body("Event accepted: " + event.eventId());
    }
}
