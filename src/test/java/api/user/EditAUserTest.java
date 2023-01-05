package api.user;

import api.BaseTest;
import api.endpoints.Endpoints;
import api.modal.UserDTO;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.constants.Constants;

public class EditAUserTest extends BaseTest {

    String id;

    @BeforeTest
    public void createAUser() {
        id = createAUserAndReturnId(Constants.TIM_D_TESTER, Constants.JOB_QA);
    }

    @Test
    public void editAUser() {
        var response = RestAssured
                .given()
                .spec(getRequestSpec())
                .body(UserDTO
                        .builder()
                        .name(Constants.RAM_D_TESTER)
                        .job(Constants.JOB_TUTORIAL_MAKER)
                        .build())
                .when()
                .put(Endpoints.BASE_ENDPOINT + Endpoints.USERS + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
        System.out.println(response.extract().asPrettyString());
    }
}
