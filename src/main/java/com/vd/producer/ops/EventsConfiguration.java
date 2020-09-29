package com.vd.producer.ops;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Configuration
public class EventsConfiguration {

    @Bean
    public EmitterProcessor<String> emitterProcessor(){
        return EmitterProcessor.create();
    }

    @Bean
    public Supplier<Flux<String>> supplier() {
        return this::emitterProcessor;
    }

}
