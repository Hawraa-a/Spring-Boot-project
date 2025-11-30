package com.codeline.ccsb.controllers;

import com.codeline.ccsb.DTO.ProductDto;
import com.codeline.ccsb.entities.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codeline.ccsb.services.ProductService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("create")
    public Product createCourses(@Valid @RequestBody ProductDto requestObj) {
        return productService.saveProduct(requestObj);
    }

    @GetMapping("getAll")
    public List<Product> getAllCourses() {
        List<Product> productList = productService.getAllActiveProduct();
        return productList;
    }

    @GetMapping("getById")
    public Product getProduct(@RequestParam int id) throws Exception {
        return productService.getProductById(id);
    }

    @PutMapping("update/{id}")
    public Product updateProduct(@PathVariable Integer id, @Valid @RequestBody ProductDto updateObj) throws Exception {
        return productService.updateProduct(id, updateObj);
    }

    @DeleteMapping("delete/{id}")
    public String deleteProduct(@PathVariable int id) throws Exception {
        productService.deleteProduct(id);
        return "SUCCESS";
    }
}
