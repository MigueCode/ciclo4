package com.reto2.backend.service;

import com.reto2.backend.model.CleaningProduct;
import com.reto2.backend.repository.CleaningProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleaningProductService {

    @Autowired
    private CleaningProductRepository cleaningProductRepository;

    public List<CleaningProduct> getAll(){
        return cleaningProductRepository.getAll();
    }

    public Optional<CleaningProduct> getProduct(Integer id){
        return cleaningProductRepository.getProduct(id);
    }

    public CleaningProduct save(CleaningProduct cleaningProduct){
        if (cleaningProduct.getId()==null){
            return cleaningProduct;
        }

        return cleaningProductRepository.save(cleaningProduct);
    }

    public CleaningProduct update(CleaningProduct cleaningProduct){
        if (cleaningProduct.getId()==null){
            return cleaningProduct;
        }

        Optional<CleaningProduct> product = cleaningProductRepository.getProduct(cleaningProduct.getId());

        if (product.isEmpty()){
            return cleaningProduct;
        }

        if (cleaningProduct.getBrand()!=null){
            product.get().setBrand(cleaningProduct.getBrand());
        }

        if (cleaningProduct.getCategory()!=null){
            product.get().setCategory(cleaningProduct.getCategory());
        }

        if (cleaningProduct.getName()!=null){
            product.get().setName(cleaningProduct.getName());
        }

        if (cleaningProduct.getDescription()!=null){
            product.get().setDescription(cleaningProduct.getDescription());
        }

        if (cleaningProduct.getPrice()!=null){
            product.get().setPrice(cleaningProduct.getPrice());
        }

        if (cleaningProduct.getQuantity()!=null){
            product.get().setQuantity(cleaningProduct.getQuantity());
        }

        if (cleaningProduct.getPhotography()!=null){
            product.get().setPhotography(cleaningProduct.getPhotography());
        }

        product.get().setAvailability(cleaningProduct.isAvailability());

        cleaningProductRepository.update(product.get());

        return product.get();
    }

    public boolean delete(Integer id){
        Boolean aboolean= getProduct(id).map(cleaningProduct -> {
            cleaningProductRepository.delete(cleaningProduct);
            return true;
        }).orElse(false);
        return aboolean;
    }
}
