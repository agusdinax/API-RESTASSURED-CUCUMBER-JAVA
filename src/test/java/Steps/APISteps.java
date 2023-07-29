package Steps; 
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured.given;
import org.junit.Assert.assertEquals;



public class APISteps {
    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given ("^I send a GET request to the (.+) URI$")
    public void sendGETRequest (String URI){
        request = given()
                    .baseUri(URI)
                    .contentType(ContentType.JSON);
    }

    @Then ("^I get a (\\d+) status code$")
    public void expectedStatusCode (int statusCode){
        response = request
                .when()
                .get("/users/agusdinax/repos");

                json = response.then().statusCode(expectedStatusCode);
    }

    @Then("^I validate there are (\\d+) items on the (.+) endpoint$")
    public void validateSize(int expectedSize, String endpoint){
        response = request 
                    .when()
                    .get(endpoint);

                    List<String> actualSize jsonResponse = response.jsonPath().getList("$");
                    int actualSize = jsonResponse.size();

                    assertEquals(expectedSize, actualSize);
    }

    @Then("^I validate there is a value: (.+) in the response at (.+) endpoint$")
    public void validateValue(String expectedValue, String endpoint){
        response = request 
        .when()
        .get(endpoint);

        List<String> actualSize jsonResponse = response.jsonPath().getList("username");
        assertTrue("El valor "+expectedValue+" no se encuentra en la lista.",jsonResponse.contains(expectedValue));

    }
    
}