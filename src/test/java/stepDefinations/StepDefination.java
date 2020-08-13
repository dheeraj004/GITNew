package stepDefinations;

import static io.restassured.RestAssured.given;



import org.junit.Assert;
import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resourses.APIResource;
import resourses.TestDataBuilder;
import resourses.Utilis;

@RunWith(Cucumber.class)
public class StepDefination {
	RequestSpecification res ;
	ResponseSpecification resspec;
	Response response;
	static  String place_id;



    

	@Given("Add Place Payload with {string}   {string}   {string}")
    public void add_place_payload_with(String name, String language, String address) throws Throwable 
    	{
  	  		res=given().spec(Utilis.requestSpecification())
				 .body(TestDataBuilder.addPlacePayload(name, language, address));
    	}


@When("User calls {string} with {string} http request")
public void user_calls_with_http_request(String resource, String method) throws Throwable {

		APIResource apiresource=APIResource.valueOf(resource);
		System.out.println(apiresource.getResource());
	
    	 resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    	 if(resource.equalsIgnoreCase("POST"))
    	 {
    	     response =res.when().post(apiresource.getResource());
    	 }
    	 else if (resource.equalsIgnoreCase("Get"))
    	 {
    		 response =res.when().post(apiresource.getResource());
    	 }
    	 else
    	 {
    		 response =res.when().post(apiresource.getResource());
    	 }

    			//then().spec(resspec).extract().response();
    }

    @Then("^the API call is success with status code 200$")
    public void the_api_call_is_success_with_status_code_200() throws Throwable {
    	Assert.assertEquals(response.getStatusCode(), 200);
    
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String keyvalue, String expectedvalue) throws Throwable {

    	Assert.assertEquals(Utilis.getJsonPath(response, keyvalue),expectedvalue);
    	
    }
    
    
    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws Throwable {
    
    	place_id= 	Utilis.getJsonPath(response, "place_id");
    	res=given().spec(Utilis.requestSpecification()).queryParam("place_id", place_id);
    	user_calls_with_http_request(resource, "GET");
    	String actualname= 	Utilis.getJsonPath(response, "name");
    	Assert.assertEquals(actualname,expectedname);
    }
    
    @Given("deletePlaceAPI Payload")
    public void delete_place_api_payload() throws Exception {
    	
    	res=given().spec(Utilis.requestSpecification()).body(TestDataBuilder.deleteAPIPayload(place_id));
        
    }


}