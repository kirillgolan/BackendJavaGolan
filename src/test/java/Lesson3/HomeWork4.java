package Lesson3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class HomeWork4 extends AbstractTest {

    @BeforeAll
    static void setUp(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    @Test
    void italianFoodGet(){

        given().spec(getRequestSpecification())
                .queryParam("cuisine", "italian")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .prettyPeek()
                .then()
                .spec(responseSpecification);

    }

    @Test
    void italianVegetarianGet() {

        given().spec(getRequestSpecification())
                .queryParam("cuisine", "italian")
                .queryParam("diet", "vegetarian")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .spec(responseSpecification);

    }

    @Test
    void koreanGlutenFreeGet() {

        given().spec(getRequestSpecification())
                .queryParam("cuisine", "korean")
                .queryParam("diet", "gluten free")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void thaiVeganGet() {

        given().spec(getRequestSpecification())
                .queryParam("cuisine", "thai")
                .queryParam("diet", "vegan")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void italianKetogenicGet() {

        given().spec(getRequestSpecification())
                .queryParam("cuisine", "italian")
                .queryParam("diet", "ketogenic")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void chickenSoupPost() {

        given().spec(getRequestSpecification())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "chiken soup")
                .formParam("ingredient list", "chicken water")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void cheeseSoupPost() {

        given().spec(getRequestSpecification())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "cheese soup")
                .formParam("ingredient list", "cheese water")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void porkSoupPost() {

        given().spec(getRequestSpecification())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "pork soup")
                .formParam("ingredient list", "pork water")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void horseSoupPost() {

        given().spec(getRequestSpecification())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "horse soup")
                .formParam("ingredient list", "horse water")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void crabSoupPost() {

        given().spec(getRequestSpecification())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "crab soup")
                .formParam("ingredient list", "crab water")
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .spec(responseSpecification);
    }

}