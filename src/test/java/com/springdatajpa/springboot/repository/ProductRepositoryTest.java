package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        // create product
        Product product = new Product();
        product.setName("product 2");
        product.setDescription("product 2 description");
        product.setSku("120ABC");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product2.png");

        // save product
        Product savedObject = productRepository.save(product);

        // display product
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod(){

        // find or retrive an entity by id
        Long id = 1l;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 desc");

        // save update entity
        productRepository.save(product);
    }
}
