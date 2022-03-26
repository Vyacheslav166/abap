import model.ObjectJson;
import service.Service;
import java.net.MalformedURLException;
import java.net.URL;
import static map.MapJsonToJavaObject.readJson;

public class Main {

    private static final String URL_API_Khabarovsk = "https://api.openweathermap.org/data/2.5/onecall?" +
            "lat=48.481403&lon=135.076935&exclude=current,minutely,hourly,alerts&units=metric" +
            "&appid=59d7738c0dc915f3dbda2121f91b2eb2";


    public static void main(String[] args) {
        ObjectJson objectJson = new ObjectJson();
        //получаем ObjectJson из api
        try {
            objectJson = readJson(new URL(URL_API_Khabarovsk));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (objectJson != null) {
            System.out.println(Service.giveDayMinDifferentTemp(objectJson));
            System.out.println(Service.giveMaxDayLengthFiveDay(objectJson));
        }
    }
}