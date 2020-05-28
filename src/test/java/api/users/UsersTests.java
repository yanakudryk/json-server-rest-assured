package api.users;

import api.base.BaseTests;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import dataentities.User;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static constants.Constants.*;
import static endpoints.EndPoints.USERS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class UsersTests extends BaseTests {
    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;

    private User createUser(User userIn){
        return
                given().
                        spec(requestSpecification).
                        contentType(ContentType.JSON).
                        body(userIn).
                        log().
                        all().
                when().
                        post(USERS).
                then().
                        log().
                        all().
                        statusCode(201).
                        contentType(ContentType.JSON).
                        extract().
                        body().
                        as(User.class);
    }

    @BeforeClass
    public static void createRequestSpec(){
                requestSpecification = new RequestSpecBuilder().
                        setBaseUri(USERS).
                        setAuth(RestAssured.oauth2(getAccessToken())).
                        build();
    }


    @DataProvider
    public static Object[][] usersData(){
        return new Object[][]{
                {"2", "Lilia Evans", "female", 30.263407, 94.946584},
                {"3", "Washington Sweet", "male", -53.894509, -117.4587},
                {"4", "Justine Lawson", "female", -66.286489, 49.377613}
        };
    }
    @UseDataProvider("usersData")
    @Test
    public void PositiveGetUsersTest(String id, String name, String gender, double latitude, double longitude){
        User user =
        given().
                spec(requestSpecification).
                pathParam("id", id).
                log().
                all().
        when().
                get("/{id}").
        then().
                log().
                all().
                statusCode(200).
                contentType(ContentType.JSON).
                extract().
                body().
                as(User.class);

        Assert.assertEquals(name, user.getName());
        Assert.assertEquals(gender, user.getGender());
        Assert.assertEquals(latitude, user.getLatitude(), 2);
        Assert.assertEquals(longitude, user.getLongitude(), 2);
    }
    @Test
    public void PositivePostUser(){
        String generatedString = RandomStringUtils.random(5, true, false);

        User userIn = new User(
                generatedString + "@mail.com",
                PASSWORD, AGE,
                NAME,
                GENDER);

        User userOut = createUser(userIn);

        Assert.assertEquals(userIn.getName(), userOut.getName());
        Assert.assertEquals(userIn.getEmail(), userOut.getEmail());
        Assert.assertEquals(userIn.getGender(), userOut.getGender());
        Assert.assertEquals(userIn.getAge(), userOut.getAge());
    }

    @Test
    public void PositiveDeleteUser(){

        User userIn = new User(
                EMAIL,
                PASSWORD,
                AGE,
                NAME,
                GENDER);

        User userOut = createUser(userIn);
        String userID = Integer.toString(userOut.getId());

        given().
                spec(requestSpecification).
                pathParam("userID", userID).
                log().
                all().
        when().
                delete("/{userID}").
        then().
                log().
                all().
                assertThat().
                statusCode(200).
                body("isEmpty()", is(true));
    }
    @Test
    public void PositivePatchUser(){
        String generatedString = RandomStringUtils.random(5, true, false);

        User userIn = new User(
                generatedString + "@mail.com",
                PASSWORD, AGE,
                NAME,
                GENDER);

        User userOut = createUser(userIn);

        String userOutId = Integer.toString(userOut.getId());

        userIn.setEmail(generatedString + "Updated" + "@mail.com");

        User userOutUpd =
                given().
                        spec(requestSpecification).
                        contentType(ContentType.JSON).
                        body(userIn).
                        pathParam("userOutId", userOutId).
                        log().
                        all().
                when().
                        patch("/{userOutId}").
                then().
                        log().
                        all().
                        statusCode(200).
                        extract().
                        body().
                        as(User.class);

        Assert.assertEquals(userIn.getEmail(), userOutUpd.getEmail());
    }
    @Test
    public void NegativeGetUsersWithoutAuth(){
        given().
                log().
                all().
        when().
                get(USERS).
        then().
                log().
                all().
                assertThat().
                statusCode(401).
                contentType(ContentType.JSON).
                body(containsString("Missing authorization header"));
    }

}
