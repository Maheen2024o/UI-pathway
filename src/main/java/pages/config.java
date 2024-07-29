package pages;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class config {
    private static JSONObject config;

    static {
        try (FileReader reader = new FileReader("src\\main\\java\\config.json")) {
            JSONParser parser = new JSONParser();
            config = (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static String getBrowser() {
        return (String) config.get("browser");
    }
}
