package api;

import api.modal.UserDTO;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .addHeader("content-type", "application/json")
                .build();
    }

    public static String createAUserAndReturnId(String name, String job) {
        return RestAssured
                .given()
                .spec(getRequestSpec())
                .body(UserDTO
                        .builder()
                        .name(name)
                        .job(job)
                        .build())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .extract()
                .body()
                .jsonPath()
                .get("id");
    }
}
