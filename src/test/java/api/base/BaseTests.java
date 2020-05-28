package api.base;

import io.restassured.http.ContentType;
import token.AccessToken;
import token.Credentials;

import static endpoints.EndPoints.LOGIN;
import static io.restassured.RestAssured.given;

public class BaseTests {
    protected static String getAccessToken(){
        Credentials credentials = new Credentials("admin@mail.com", "bestPassw0rd");

        AccessToken accessToken =
                given().
                        contentType(ContentType.JSON).
                        body(credentials).
                        log().
                        all().
                when().
                        post(LOGIN).
                then().
                        log().
                        all().
                        extract().
                        body().
                        as(AccessToken.class);
        return accessToken.getAccessToken();
    }
}
