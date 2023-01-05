package api.user;

import api.BaseTest;
import api.endpoints.Endpoints;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class GetUsersTest extends BaseTest {

    Integer numberOfPages;

    @Test
    public void getAListOfUsers() {
        numberOfPages = tryToFetchTotalPages();
        for (int i = 1; i <= numberOfPages; i++) {
            var response = RestAssured
                    .given()
                    .queryParam("page", i)
                    .spec(getRequestSpec())
                    .when()
                    .get(Endpoints.BASE_ENDPOINT + Endpoints.USERS)
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK).extract().body().asPrettyString();
            System.out.println(response);
        }
    }

    public Integer tryToFetchTotalPages() {
        var response = RestAssured
                .given()
                .spec(getRequestSpec())
                .when()
                .get(Endpoints.BASE_ENDPOINT + Endpoints.USERS)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().body().jsonPath().get("total_pages").toString();
        return Integer.parseInt(response);
    }
}
