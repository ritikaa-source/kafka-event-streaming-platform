package com.example.analytics.model;
import java.time.Instant;
public record DigitalEvent(String eventId,String eventType,String userId,String contentId,String deviceId,Instant timestamp) {}
