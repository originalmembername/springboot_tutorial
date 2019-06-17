package com.example.spring_tutorial.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Car {
    private UUID id;
    @NotBlank
    private final String brand;
    @NotBlank
    private final String model;

    public Car(@JsonProperty("id") UUID id, @JsonProperty("brand") String brand, @JsonProperty("model") String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public UUID getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}

