package Steps; 
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured.given;
import org.junit.Assert.assertEquals;

public class BraveNewCoinAPISteps {
    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given("^I have a valid API Key for the (.+) URI$"){
        public void iSetTheRequestParams (String URI){
            request = given().relaxedHTTPSValidation().header("x-rapidapi-key", "bfe406de48msh0d0e4e0df41592fp1cb0e8jsn962053550e3")
            .header("x-rapidapi-host", "bravenewcoin.p.rapidapi.com").contentType(ContentType.JSON).baseUri(URI)
            .log().all();
        }
    }

    @when("^I send a POST request with a valid body to the (.+) endpoint$"){
        public void sendPOSTRequest (String endpoint, String payload){
            File requestBody = new File("src/test/resources/Payloads/"+payload+".json");
            response = request.when().body(requestBody).post(endpoint).prettyPeek();
        }

    }
    
}
