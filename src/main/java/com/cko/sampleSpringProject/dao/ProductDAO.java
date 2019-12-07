package com.cko.sampleSpringProject.dao;

import com.cko.sampleSpringProject.model.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDAO extends CrudRepository<Products, Long> {
    Products findProductsById(Long id);
    void deleteById(Long id);
    List<Products> findAll();

    List<Products> findByPriceLessThanEqual(int price);
}