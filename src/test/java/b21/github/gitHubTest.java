package b21.github;

// import io.restassured.RestAssured;
import io.restassured.RestAssured;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static net.serenitybdd.rest.SerenityRest.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


@SerenityTest
public class gitHubTest {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "https://api.github.com";
    }

    @Test
    public void testGitHubUser(){

        given()
                .pathParam("user_id" , "CybertekSchool")
                .log().all().
                when()
                .get("/users/{user_id}").
                then()
                .log().all()
                .statusCode(200) ;

    }
    @Test
    public void testGitHubUser2() {
        SerenityRest.given()
                .pathParam("user_id" , "CybertekSchool").
                //.log().all().
                        when()
                .get("/users/{user_id}") ;
        // If you send request using SerenityRest , the response object
        // can be obtained from the method called lastResponse() without being saved separately

        System.out.println(    SerenityRest.lastResponse().statusCode()  );
        System.out.println(  lastResponse().header("Date")     );
        // print the response field login and id
        String loginFieldValue = lastResponse().path("login") ;
        System.out.println("loginFieldValue = " + loginFieldValue);

        System.out.println(lastResponse().jsonPath().getInt("id")  ) ;



    }
    @Test
    public void testGitHubUser3() {
        SerenityRest.given()
                .pathParam("user_id" , "CybertekSchool").
                //.log().all().
                        when()
                .get("/users/{user_id}") ;
        // our objective is to let each assertion show up in the report as step
        // check status code and let it show in the report
        // this is import import net.serenitybdd.rest.Ensure
        Ensure.that("request ran successfully",   thenSection -> thenSection.statusCode(200)  ) ;

        Ensure.that("login field value is CybertekSchool",
                thenSection -> thenSection.body("login",  is("CybertekSchool") ) );


    }

    @AfterAll
    public static void cleanup(){
        RestAssured.reset();
    }



}

