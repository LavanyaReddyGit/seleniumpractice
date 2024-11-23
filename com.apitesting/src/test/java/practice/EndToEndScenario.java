package practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import file.PayLoad;
import file.ReusabilityMethod;

public class EndToEndScenario {

	public static void main(String[] args) {
		// Add place
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given().log().all().queryParam("key","qaclick123")
		.header("Content-Type","application/json")
		.body(PayLoad.addPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().statusCode(200).body("scope", equalTo("APP"))
		.extract().response().asString();
		
		JsonPath js=new JsonPath(response);
		String place_id=js.getString("place_id");
		
		System.out.println(place_id);
		
		
		
		System.out.println("****************");
		
		//Update place
		
		
		String newAddress=" Washington USA";
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"place_id\":\""+place_id+"\", \r\n"
				+ "   \"address\": \""+newAddress+"\",\r\n"
				+ "  \"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		
		
		System.out.println("****************");
		
		
		//Get Address
		
		
		String getPlaceResponse=given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", place_id)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		
		JsonPath js1=ReusabilityMethod.rawToJson(getPlaceResponse);
		String actualAddress=js1.getString("address");
		
		System.out.println(actualAddress);
		
		
		 // Assert to verify the updated address
        if (newAddress.equals(actualAddress)) {
            System.out.println("Address updated successfully.");
        } else {
            System.out.println("Address update failed.");
        }
        
        Assert.assertEquals(newAddress, actualAddress);

        System.out.println("****************");
    }
		
		
		
		
		
		
		
		
		
		

	}


