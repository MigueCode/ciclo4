package com.reto2.backend.repository;

import com.reto2.backend.model.CleaningProduct;
import com.reto2.backend.repository.crud.CleaningProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CleaningProductRepository {

    @Autowired
    private CleaningProductCrudRepository cleaningProductCrudRepository;

    public List<CleaningProduct> getAll(){
        return cleaningProductCrudRepository.findAll();
    }

    public Optional<CleaningProduct> getProduct(Integer id){
        return cleaningProductCrudRepository.findById(id);
    }

    public CleaningProduct save(CleaningProduct cleaningProduct){
        return cleaningProductCrudRepository.save(cleaningProduct);
    }

    public void update(CleaningProduct cleaningProduct){
        cleaningProductCrudRepository.save(cleaningProduct);
    }

    public void delete(CleaningProduct cleaningProduct){
        cleaningProductCrudRepository.delete(cleaningProduct);
    }
}
