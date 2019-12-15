package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.ProductDAO;
import com.cko.sampleSpringProject.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductDAO productDAO;
    Long qq;


    @GetMapping("/all")
    public ModelAndView allProducts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Products/AllProducts");
        List<Products> productList = productDAO.findAll();

        modelAndView.addObject("products", productList);
        return modelAndView;
    }

    @PostMapping("/search")
    public String Search(@RequestParam(value = "price", required = true) Integer price, Map<String, Object> search) {
        Iterable<Products> products;
        if (price == null) {
            products = productDAO.findAll();
        } else {
            products = productDAO.findByPriceLessThanEqual(price);
        }
        search.put("products", products);
        return "Products/AllProducts";
    }

    @GetMapping("/add")
    public String addProducts() {
        return "Products/AddProducts";
    }

    @PostMapping("/add")
    public RedirectView addNewProducts(Products products) {
        productDAO.save(products);
        return new RedirectView("/products/all");
    }


    @GetMapping("/edit")
    public ModelAndView editProducts(Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Products products = productDAO.findProductsById(id);
        modelAndView.addObject("products", products);
        modelAndView.setViewName("Products/EditProducts");
        return modelAndView;
    }

    @PostMapping("/edit")
    public RedirectView editFilm(Products products) {
        productDAO.save(products);
        return new RedirectView("Products/EditProducts");
    }

    @GetMapping("/delete")
    public RedirectView Delete(@RequestParam long id) {
        Products products = productDAO.findProductsById(id);
        if (products.getAmount() > 0) {
            products.setAmount(products.getAmount() - 1);
            productDAO.save(products);
        }
        return new RedirectView("/products/all");
    }


    @GetMapping("/buy")
    public ModelAndView ProcBuy(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Products products = productDAO.findProductsById(id);
        qq = products.getId();
        modelAndView.addObject("product", products);
        modelAndView.setViewName("Products/ProductPage");
        return modelAndView;
    }
    @PostMapping("/buy")
    public RedirectView Buy(int count) {
        Products products = productDAO.findProductsById(qq);
        if (products.getAmount() > count) {
            products.setAmount(products.getAmount() - count);
            productDAO.save(products);
            return new RedirectView("/products/tenQ");
        } else if (products.getAmount() == count) {
            productDAO.deleteById(qq);
            return new RedirectView("/products/tenQ");
        } else {
            return new RedirectView("/products/error");
        }
    }

    @GetMapping("/tenQ")
    public String tenQ() {
        return "Products/ProductTenQ";
    }

    @GetMapping("/error")
    public String error() {
        return "Products/ProductError";
    }


}