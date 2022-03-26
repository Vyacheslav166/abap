package map;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ObjectJson;


import java.net.URL;

/**
 * Парсер JSON, получаемых с вебсервиса
 */
public class MapJsonToJavaObject {

    /**
     * Получение JSON по заданному работодателю и преобразование в объект Java
     *
     * @param url - api запроса
     * @return Java объект ObjectJson
     */
    public static ObjectJson readJson(URL url) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return (mapper.readValue(url, ObjectJson.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}