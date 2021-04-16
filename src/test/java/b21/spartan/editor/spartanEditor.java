package b21.spartan.editor;
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


public class spartanEditor {

    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "http://18.235.32.166:7000";
        RestAssured.basePath = "/api";
    }
    @AfterAll
    public static void cleanup() {
        reset();

    }
    @DisplayName("Test Admin GET /spartans endpoint")
    @Test
    public void testEditorSpartansData(){



    }


}