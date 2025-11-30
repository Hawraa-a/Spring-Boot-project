package com.codeline.ccsb.services;

import com.codeline.ccsb.DTO.ProductDto;
import com.codeline.ccsb.entities.Product;
import com.codeline.ccsb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setAvailableQuantity(productDto.getAvailableQuantity());

        product.setCreateDate(new Date());
        product.setIsActive(Boolean.TRUE);
        return productRepository.save(product);
    }

    public List<Product> getAllActiveProduct() {
        return productRepository.findAll().stream().filter(product -> product.getIsActive()).toList();
    }

    public Product getProductById(Integer id) throws Exception {
        Product existingProduct = productRepository.findById(id).get();
        if (existingProduct != null && existingProduct.getIsActive()) {
            return existingProduct;
        } else {
            throw new Exception("Bad Request");
        }
    }

    public Product updateProduct(Integer id, ProductDto dto) throws Exception {
        Product existingProduct = productRepository.findById(id).get();
        if (existingProduct != null && existingProduct.getIsActive()) {
            existingProduct.setName(dto.getName());
            existingProduct.setCategory(dto.getCategory());
            existingProduct.setPrice(dto.getPrice());
            existingProduct.setAvailableQuantity(dto.getAvailableQuantity());
            existingProduct.setUpdatedDate(new Date());
            return productRepository.save(existingProduct);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public void deleteProduct(Integer id) throws Exception {
        Product existingProduct = productRepository.findById(id).get();
        if (existingProduct != null && existingProduct.getIsActive()) {
            existingProduct.setUpdatedDate(new Date());
            existingProduct.setIsActive(Boolean.FALSE);
            productRepository.save(existingProduct);
        } else {
            throw new Exception("Bad Request");
        }
    }
}
