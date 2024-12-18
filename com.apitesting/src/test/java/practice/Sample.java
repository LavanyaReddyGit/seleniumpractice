package practice;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import file.PayLoad;

public class Sample {

	public static void main(String[] args) {

		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		// given() (for all inputs), when()( to use http methods), then() (for validations)
		
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(PayLoad.addPlace())
		.when().post("maps/api/place/add/json")
		
		.then().log().all().statusCode(200).body("scope", equalTo("APP"));
		
		
	
		
		
		
		
	}
}
