package com.reto2.backend.service;

import com.reto2.backend.repository.CleaningProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CleaningProductService {

    @Autowired
    private CleaningProductRepository cleaningProductRepository;
}
