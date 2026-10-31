package com.example.streams.config;

import com.example.streams.model.DigitalEvent;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JacksonJsonSerde;

@Configuration
public class StreamsTopologyConfig {

    @Bean
    public KStream<String, DigitalEvent> digitalEvents(StreamsBuilder builder) {

        JacksonJsonSerde<DigitalEvent> eventSerde =
                new JacksonJsonSerde<>(DigitalEvent.class);

        KStream<String, DigitalEvent> stream = builder.stream(
                "digital.events",
                Consumed.with(Serdes.String(), eventSerde)
        );

        stream.filter((key, event) ->
                        event != null
                                && event.userId() != null
                                && !event.userId().isBlank()
                )
                .selectKey((key, event) -> event.userId())
                .groupByKey(Grouped.with(Serdes.String(), eventSerde))
                .count()
                .toStream()
                .to(
                        "digital.user.event.counts",
                        Produced.with(Serdes.String(), Serdes.Long())
                );

        return stream;
    }
}