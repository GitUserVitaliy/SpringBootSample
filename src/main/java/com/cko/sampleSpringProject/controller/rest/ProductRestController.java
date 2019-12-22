package com.cko.sampleSpringProject.controller.rest;

import com.cko.sampleSpringProject.dao.ProductDAO;
import com.cko.sampleSpringProject.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    ProductDAO productDAO;
    @PostMapping("/add")
    public void addProduct(@RequestBody Products products) {
        productDAO.save(products);
    }
    @GetMapping("/get")
    public Products getProductById(@RequestParam Long id) {
        return productDAO.findProductsById(id);
    }
    @GetMapping("/all")
    public List<Products> getAllProducts() {
        return productDAO.findAll();
    }
}
