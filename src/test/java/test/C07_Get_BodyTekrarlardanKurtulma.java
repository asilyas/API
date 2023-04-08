package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C07_Get_BodyTekrarlardanKurtulma {
 /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"James",
                    ve "lastname“in, "Brown",
                    ve "totalprice“in, 111,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */
    @Test
    public void get01(){
        //1-Request için gerekli url i hazırla
        String url="https://restful-booker.herokuapp.com/booking/10";
        //2-Expected Data hazirla

        //3-Response ı kaydet

        Response response=given().when().get(url);
        response.prettyPrint();
        //4-Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Mark"),
                        "lastname",Matchers.equalTo("Jackson"),
                        "totalprice",Matchers.equalTo(233),
                        "depositpaid",Matchers.equalTo(false),
                        "additionalneeds",Matchers.equalTo("Breakfast"));
    }

}
