package com.data.multi.db;

import com.data.multi.db.product.controller.ProductController;
import com.data.multi.db.product.dto.ProductResponse;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Test
    public void test_get_all_product() {
        given()
                .when()
                .get("/product/all")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("size", greaterThan(0))
                .body("[0].productName", notNullValue())
                .body("[0].price", notNullValue());
    }
}
