package b21.spartan.admin;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static net.serenitybdd.rest.SerenityRest.reset;
import static org.hamcrest.Matchers.hasSize;

@SerenityTest
public class SpartanAdminTest {


    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://18.235.32.166:7000" ;
        RestAssured.basePath = "/api" ;

    }

    @DisplayName("Test Admin GET /spartans endpoint")
    @Test
    public void testAllSpartans(){

        SerenityRest.given()
                        .auth().basic("admin","admin")
                        .log().all().
                    when()
                        .get("/spartans")
//                    .then()
//                            .statusCode(200)
//                            .contentType(ContentType.JSON)
        ;
        // Ensure.that("YOUR DESCRIPTION" , yourVarName-> yourVarName.YourThenSectionAssertions ) ;
        Ensure.that("Successful 200 Response" , p -> p.statusCode(200) ) ;
        Ensure.that("Content type is json" , vRes-> vRes.contentType(ContentType.JSON) ) ;
        Ensure.that("Response has correct size" , vRes-> vRes.body("", hasSize(473)));


    }



    @AfterAll
    public static void cleanup(){
        reset();
    }


}
