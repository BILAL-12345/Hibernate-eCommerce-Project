package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class NamedQuriesTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void namedJPQLQuery(){

        Product product = productRepository.findByPrice(new BigDecimal(100));
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }
}
