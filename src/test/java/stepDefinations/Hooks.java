package stepDefinations;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@deletePlace")
	public void beforeScenario() throws Throwable
	{
		StepDefination sd=new StepDefination();
		if(StepDefination.place_id==null)
		{
			sd.add_place_payload_with("Rahul", "Marathi", "Belgaon");
			sd.user_calls_with_http_request("addPlaceAPI", "POST");
			sd.verify_place_id_created_maps_to_using("Rahul", "getPlaceAPI");
		}
	}

}
