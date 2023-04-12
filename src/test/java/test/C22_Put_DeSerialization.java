package test;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlacaHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseURL {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
    @Test
    public void put01(){
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        TestDataJsonPlacaHolder testDataJsonPlacaHolder=new TestDataJsonPlacaHolder();

        HashMap<String,Object>reqBody=testDataJsonPlacaHolder.reqBodyOlusturMap();
        //2-Expected data hazırla

        HashMap<String,Object>expBody=testDataJsonPlacaHolder.reqBodyOlusturMap();

        //3-Response u kaydet
        Response response=given().spec(specJsonPlace).contentType(ContentType.JSON)
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .put("/{pp1}/{pp2}");


        response.prettyPeek();
        //4-Assertion
        HashMap<String,Object>resMap=response.as(HashMap.class); // bu adım da De-serialization işlemi yaptık

        assertEquals(testDataJsonPlacaHolder.basariliStatusCode,response.getStatusCode());
        assertEquals(expBody.get("id"),resMap.get("id"));
        assertEquals(expBody.get("title"),resMap.get("title"));
        assertEquals(expBody.get("body"),resMap.get("body"));
        assertEquals(expBody.get("userid"),resMap.get("userid"));
    }

}
