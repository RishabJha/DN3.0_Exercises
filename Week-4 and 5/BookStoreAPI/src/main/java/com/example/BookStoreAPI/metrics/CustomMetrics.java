package com.example.BookStoreAPI.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    @Bean
    public CustomMetrics registerCustomMetrics(MeterRegistry registry) {
        registry.counter("custom.book.requests", "type", "total").increment();
        registry.gauge("custom.book.price.average", getAverageBookPrice());
        return this;
    }

    private double getAverageBookPrice() {
        return 19.99;
    }
}
