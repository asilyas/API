package pojos;

public class JsonPlacaHolderReqBodyPojo {
    //1- tum key değerleri class levelde aldıkları data türüne göre private variable olarak oluşturalım

    /*
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    private String title;
    private String body;
    private int userId;
    private int id;

    //2-Tum variable lar için getter()  - setter() ları oluşturalım


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //3-tüm parametreleri içeren parametreli constructer olusturalım


    public JsonPlacaHolderReqBodyPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    //4-Parametreli consructer oluşturduğumuz için bir tane de parametresiz cons oluşturuyoruz


    public JsonPlacaHolderReqBodyPojo() {

    }

    //5-to String oluşturuyoruz


    @Override
    public String toString() {
        return "JsonPlacaHolderReqBodyPojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';

    }
}
