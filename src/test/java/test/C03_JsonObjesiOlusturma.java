package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {
   /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
    */


    @Test
    public void jsonObje1() {
        JSONObject ilkJasonObje = new JSONObject();

        ilkJasonObje.put("title", "Ahmet");
        ilkJasonObje.put("body", "Merhaba");
        ilkJasonObje.put("UserId", "1");

        System.out.println(ilkJasonObje);


    }

    /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */
    @Test
    public void jsonObje2() {
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        JSONObject outerJson = new JSONObject();

        outerJson.put("fistname", "Jim");
        outerJson.put("additionalneeds", "Breakfast");
        outerJson.put("bookingdates", bookingDates);
        outerJson.put("totalprice", "111");
        outerJson.put("depositedpaid", true);
        outerJson.put("lastname", "Brown");
        System.out.println(outerJson);
    }
}