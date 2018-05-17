package org.soft.assignment.controller;

import org.soft.assignment.model.Product;
import org.soft.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Product> getList() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Product create(@RequestBody Product object) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Product update(@RequestParam String id, @RequestBody Product object) {
        throw new UnsupportedOperationException();
    }
}