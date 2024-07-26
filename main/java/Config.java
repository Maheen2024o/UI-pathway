import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static JSONObject config;

    static {
        try (FileReader reader = new FileReader("src/main/resources/config.json")) {
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