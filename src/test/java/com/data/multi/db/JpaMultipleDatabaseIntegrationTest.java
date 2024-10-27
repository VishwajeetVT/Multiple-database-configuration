package com.data.multi.db;

import com.data.multi.db.product.repository.ProductRepository;
import com.data.multi.db.user.repository.UserRepository;
import com.data.multi.db.product.model.Product;
import com.data.multi.db.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@EnableTransactionManagement
public class JpaMultipleDatabaseIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("userTransactionManager")
    public void whenCreatingUser_thenCreated() {
        User user = new User();
        user.setId(101);
        user.setFirst_name("John");
        user.setLast_name("Doe");
        user.setEmail("johndoe@example.com");
        user.setAge(29);
        user = userRepository.save(user);

        assertNotNull(userRepository.getReferenceById(user.getId()));
    }

    @Test
    @Transactional("productTransactionManager")
    public void whenCreatingProduct_thenCreated() {
        Product product = new Product();
        product.setProductId(202);
        product.setProductName("Book");
        product.setPrice(20);
        product = productRepository.save(product);

        assertNotNull(productRepository.getReferenceById(product.getProductId()));
    }
}

