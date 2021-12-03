package com.reto2.backend.repository.crud;

import com.reto2.backend.model.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CleaningProductCrudRepository extends MongoRepository<CleaningProduct, Integer> {
}
