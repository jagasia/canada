package com.canadalife.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class UserApiTest {

    @Test
    public void getUserTest() {

        given()

        .when()
            .get("https://jsonplaceholder.typicode.com/users/2")

        .then()
            .statusCode(200)
            .body("name", equalTo("Leanne Graham"));
    }
}