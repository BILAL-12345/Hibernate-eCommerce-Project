package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
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
        product.setName("product");
        product.setDescription("product description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product.png");

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

    @Test
    void findByIdMethod(){

        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod(){

        // create product
        Product product = new Product();
        product.setName("product 3");
        product.setDescription("product 3 description");
        product.setSku("130ABC");
        product.setPrice(new BigDecimal(300));
        product.setActive(true);
        product.setImageUrl("product3.png");

        // create product
        Product product4 = new Product();
        product4.setName("product 4");
        product4.setDescription("product 4 description");
        product4.setSku("140ABC");
        product4.setPrice(new BigDecimal(400));
        product4.setActive(true);
        product4.setImageUrl("product4.png");

        productRepository.saveAll(List.of(product, product4));
    }

    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();

        products.forEach((p)->{
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod(){
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){

        // find an entity by id
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        // delete(entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){

        //productRepository.deleteAll();

        Product product = productRepository.findById(5L).get();
        Product product2 = productRepository.findById(6L).get();

        productRepository.deleteAll(List.of(product,product2));
    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod(){
        Long id = 7L;
        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }
}
