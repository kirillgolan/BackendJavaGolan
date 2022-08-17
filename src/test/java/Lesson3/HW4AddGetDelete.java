package Lesson3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class HW4AddGetDelete extends AbstractTest {

    String createUserBody = "{\n"
            + "    \"username\": \"Kirill\",\n"
            + "    \"firstName\": \"Kirill\",\n"
            + "    \"lastName\": \"Ivanov\",\n"
            + "    \"email\": \"kirillgolan@mail.ru\",\n"
            + "}";

    String addFrozenPizzaBody = "{\n"
            + "    \"item\": \"1 frozen pizza\",\n"
            + "    \"aisle\": \"fridge\",\n"
            + "    \"parse\": \"true\",\n"
            + "}";


    @BeforeAll
    static void setUp(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();


    }

    @Test
    void userCreate(){
        given().spec(getRequestSpecification())
                .body(createUserBody)
                .when()
                .post(getBaseUrl() + "users/connect")
                .prettyPeek()
                .then()
                .spec(responseSpecification);

        //        "username": "kirill1",
        //        "spoonacularPassword": "salmoncakeson68bluefoodcolor",
        //        "hash": "594c042881ba02b476b56ba59b75c66a7629d275"

    }


    @Test
    void pizzaAdd(){
        given().spec(getRequestSpecification())
                .body(addFrozenPizzaBody)
                .when()
                .post(getBaseUrl() + "mealplanner/kirill1/shopping-list/items")
                .prettyPeek()
                .then()
                .spec(responseSpecification);
                }
    @Test
    void shoppingListGet(){
        given().spec(getRequestSpecification())
                .when()
                .get(getBaseUrl() + "mealplanner/kirill1/shopping-list")
                .prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void itemDelete(){
        given().spec(getRequestSpecification())
                .queryParam("id", "1272865")
                .when()
                .delete(getBaseUrl() + "mealplanner/kirill1/shopping-list/items/1272865")
                .prettyPeek()
                .then()
                .spec(responseSpecification);
    }


}