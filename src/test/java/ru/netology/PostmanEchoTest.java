package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    public void testQuery() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Vasya_55") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("Vasya_55"))
                .body("headers.content-length", equalTo("8"));
    }
}