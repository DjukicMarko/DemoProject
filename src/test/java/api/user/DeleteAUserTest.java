package api.user;

import api.BaseTest;
import api.endpoints.Endpoints;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.constants.Constants;

public class DeleteAUserTest extends BaseTest {

    String id;

    @BeforeTest
    public void createAUser() {
        id = createAUserAndReturnId(Constants.TIM_D_TESTER, Constants.JOB_QA);
    }

    @Test
    public void deleteAUser() {
        RestAssured
                .given()
                .spec(getRequestSpec())
                .when()
                .delete(Endpoints.BASE_ENDPOINT + Endpoints.USERS + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
