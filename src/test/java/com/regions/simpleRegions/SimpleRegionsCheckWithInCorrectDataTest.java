package com.regions.simpleRegions;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class SimpleRegionsCheckWithInCorrectDataTest {

    private static RequestSpecification spec;

    @BeforeEach
    public void initSpec() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://localhost:8080")
                .setBasePath("/api")
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    @Test
    public void testSimpleRegionsCheckStatusCode() {
        given().spec(spec)
                .when()
                .get("/russia")
                .then()
                .assertThat()
                .statusCode(400);
    }

    @Test
    public void testSimpleRegionsCheckBody() {
        given().spec(spec)
                .when()
                .get("/russia?region=29")
                .then()
                .assertThat()
                .body("description", not(equalTo("Саратовская область")));
    }

    @Test
    public void testSimpleRegionsCheckContentType() {
        given().spec(spec)
                .when()
                .get("/russia?region=29")
                .then()
                .assertThat()
                .contentType(not(ContentType.BINARY));
    }
}
