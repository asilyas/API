package test;

import baseUrl.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoDummyData;
import pojos.PojoDummyExpBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Get_Pojo extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */
    @Test
    public void get01() {
        //1-Url hazırla

        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        //2-Expected data

        PojoDummyData data = new PojoDummyData(3, "Ashton Cox", 86000, 66, "");

        PojoDummyExpBody exBody = new PojoDummyExpBody("success", data, "Successfully! Record has been fetched.");

        //3-Response u kaydet

        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        response.prettyPrint();

        //4-Assertion

        PojoDummyExpBody resPojo=response.as(PojoDummyExpBody.class);

        assertEquals(exBody.getStatus(),resPojo.getStatus());
        assertEquals(exBody.getMessage(),resPojo.getMessage());
        assertEquals(exBody.getData().getId(),resPojo.getData().getId());
        assertEquals(exBody.getData().getEmployee_name(),resPojo.getData().getEmployee_name());
        assertEquals(exBody.getData().getEmployee_age(),resPojo.getData().getEmployee_age());
        assertEquals(exBody.getData().getEmployee_salary(),resPojo.getData().getEmployee_salary());
        assertEquals(exBody.getData().getProfile_image(),resPojo.getData().getProfile_image());

    }
}
