package com.example.eventproducer.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;

public record DigitalEvent(
    @NotBlank String eventId,
    @NotBlank String eventType,
    @NotBlank String userId,
    String contentId,
    String deviceId,
    @NotNull Instant timestamp
) {}
