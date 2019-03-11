package hw10;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static hw10.core.YandexSpellerConstants.YANDEX_SPELLER_API_URI;
import static org.hamcrest.Matchers.lessThan;

public class TestCheckTextsApiJSON {

    @Test
    public void simpleCheckTextsTest() {
        RestAssured
                .given()
                .log().all()
                .when()
                .get(YANDEX_SPELLER_API_URI)
                .prettyPeek()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(5000L));
    }
}
