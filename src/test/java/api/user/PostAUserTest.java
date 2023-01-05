package api.user;

import api.BaseTest;
import api.endpoints.Endpoints;
import api.modal.UserDTO;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import ui.constants.Constants;

public class PostAUserTest extends BaseTest {


    @Test
    public void postAUser() {
        var response = RestAssured
                .given()
                .spec(getRequestSpec())
                .body(UserDTO
                        .builder()
                        .name(Constants.TIM_D_TESTER)
                        .job(Constants.JOB_QA)
                        .build())
                .when()
                .post(Endpoints.BASE_ENDPOINT + Endpoints.USERS)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);
        System.out.println(response.extract().asPrettyString());
    }
}
