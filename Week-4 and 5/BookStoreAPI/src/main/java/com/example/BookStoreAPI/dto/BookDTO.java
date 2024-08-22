package com.example.BookStoreAPI.dto;

import com.example.BookStoreAPI.serializer.CustomerPriceDeserializer;
import com.example.BookStoreAPI.serializer.CustomerPriceSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String author;

    @JsonProperty("isbn")
    private String isbn;

    @JsonSerialize(using = CustomerPriceSerializer.class)
    @JsonDeserialize(using = CustomerPriceDeserializer.class)
    private double price;
}

