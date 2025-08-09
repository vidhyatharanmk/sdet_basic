package com.vidhyatharan.sdet.basic.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import org.json.JSONObject;

public class RegisterApi {

	@Test
	public void testRegisterAPI() {
    	System.out.println("Start");

    	String filePath = "Logindetails.xlsx";
    	String sheetName = "Sheet1";
    	Map<String, String> credentials = ReadExcel.readCredentials(filePath, sheetName);

    	JSONObject requestBody = new JSONObject();
    	requestBody.put("email", credentials.get("email"));
    	requestBody.put("password", credentials.get("password"));
    	System.out.println("Request Body : " + requestBody);

    	Response response = RestAssured
                .given()
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post("https://reqres.in/api/register");

        System.out.println("Response Code : " + response.statusCode());
        System.out.println("Response Body : " + response.asString());

        if (response.statusCode() == 200) {
        	System.out.println("Inside if block : " + response.statusCode());
            int id = response.jsonPath().getInt("id");
            System.out.println("Id: " + id);
            String token = response.jsonPath().getString("token");
            System.out.println("Token: " + token);
            Assert.assertTrue(id > 0, "ID should be a positive integer");
            Assert.assertNotNull(token, "Token should not be null");
        } else {
        	System.out.println("Inside else block : " + response.statusCode());
            String error = response.jsonPath().getString("error");
            System.out.println("Error Text : " + error);
            Assert.assertNotNull(error, "Error message should be present");
        }
		System.out.println("End");
    }
}