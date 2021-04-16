package b21.spartan.user;

import io.restassured.RestAssured;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static net.serenitybdd.rest.SerenityRest.reset;

@SerenityTest
public class Spartans_UsersRoleTest {


    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://18.235.32.166:7000" ;
        RestAssured.basePath = "/api" ;

    }
    @AfterAll
    public static void cleanup(){
        reset();
    }

    // this is the way to change display name of parameterized test
    //  accessing row number using {index}
    //  accessing the parameter by order {argIndex}

    @ParameterizedTest(name = "Iteration {index} - GET /spartans/{0}")
    @ValueSource(ints = {1,3,5,7,8000,99} )
    public void testUserGetSingleSpartan( int spartanIdArg  ){

        System.out.println("spartanIdArg = " + spartanIdArg);
        //  SEND GET /spartans/{id} check status 200

        SerenityRest.given()
                            .pathParam("id" , spartanIdArg)
                            .auth().basic("user","user").
                     when()
                            .get("/spartans/{id}") ;

        Ensure.that("Status is 200 " , v-> v.statusCode(200)  ) ;


    }


}
