package com.cybertek.bootstrap;

import com.cybertek.entity.Product;
import com.cybertek.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataGenerator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Product pc = new Product("DELL");
        Product laptop = new Product("MACBOOK");
        Product phone = new Product("Iphone");
        Product tablet = new Product("IPAD");

        productRepository.save(pc);
        productRepository.save(laptop);
        productRepository.save(phone);
        productRepository.save(tablet);

    }
}
