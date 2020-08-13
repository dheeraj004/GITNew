Feature: Add place validations

@addPlace
Scenario Outline: Verify if Place is being added successfully added using AddplaceAPI
	Given Add Place Payload with "<name>"   "<language>"   "<address>"  
	When User calls "addPlaceAPI" with "Post" http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_Id created maps to "<name>" using "getPlaceAPI"
	


Examples:
|name| |language| |address|
|jhon| |English | |Mehkar|
# |ghon| |Mnglish | |Kehkar|

@deletePlace
Scenario: Verify Delete place API
Given deletePlaceAPI Payload
When User calls "deletePlaceAPI" with "Post" http request
Then the API call is success with status code 200
And "status" in response body is "OK"