package com.reto2.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CleaningProduct {

    @Id
    private Integer id;
    private String brand;
    private String category;
    private String name;
    private String description;
    private Double price;
    private boolean availability = true;
    private Integer quantity;
    private String photography;
}
