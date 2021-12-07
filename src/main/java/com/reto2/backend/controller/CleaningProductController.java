package com.reto2.backend.controller;

import com.reto2.backend.model.CleaningProduct;
import com.reto2.backend.service.CleaningProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CleaningProductController {

    @Autowired
    private CleaningProductService cleaningProductService;

    @GetMapping("/all")
    public List<CleaningProduct> getAll() {
        return cleaningProductService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CleaningProduct> getCleaningProduct(@PathVariable("id") Integer id) {
        return cleaningProductService.getProduct(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CleaningProduct product){
        cleaningProductService.save(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct product){
        return cleaningProductService.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return cleaningProductService.delete(id);
    }

}
