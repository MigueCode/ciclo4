package com.reto2.backend.controller;

import com.reto2.backend.service.CleaningProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CleaningProductController {

    @Autowired
    private CleaningProductService cleaningProductService;
}
