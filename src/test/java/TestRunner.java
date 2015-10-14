package com.crud.customer;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.get;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class TestRunner {
	String firstName,lastName, emailAddress, phone;

    @Before
    public void setUp(){
        // RestAssured.basePath = "http://localhost:8080";
         firstName = "Robert";	
	   	 lastName = "Longly";
	  	 emailAddress = "R-Longly@hotmail.co.uk";
	  	 phone = "020833392849";
    }

    @Test
    public void testCreateCustomer(){
    	System.out.println("test Creating Customer");
    	given().when().post("/create?firstName="+firstName)
            .then().statusCode(400);
        given().when().post("/create?firstName="+firstName+"&lastName="+lastName)
            .then().statusCode(200);
        given().when().post("/create?firstName="+firstName+"&lastName="+lastName+"&email="+emailAddress)
            .then().statusCode(200);
        given().when().post("/create?firstName="+firstName+"&lastName="+lastName+"&email="+emailAddress+"&phone"+phone)
            .then().statusCode(200);
        System.out.println("success");
    }

    @Test
    public void testListCustomer(){
    	System.out.println("test Listing");
    	given().when().get("/")
            .then().statusCode(200);
        given().when().post("/")
            .then().statusCode(405);
    	Long userId = get("/").path("[0].id");
    	given().when().get("/find/"+userId)
            .then().statusCode(200);
        System.out.println("success");
    }
    @Test
    public void testUpdateCustomer(){
    	System.out.println("test update");
    	Long userId = get("/").path("[0].id");
        given().when().put("/update/"+userId+"?firstName="+"Gregg"+"&lastName="+lastName+"&email="+"Gregg@hotmail.com"+"&phone"+phone)
            .then().statusCode(200);
        System.out.println("success");
    }
    @Test
    public void testDeleteCustomer(){
    	System.out.println("test update");
    	Long userId = get("/").path("[0].id");
        given().when().delete("/delete/"+userId)
            .then().statusCode(200);
        System.out.println("success");
    }
}



