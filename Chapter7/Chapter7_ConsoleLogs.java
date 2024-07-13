package Chapter7;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static javax.swing.UIManager.put;

public class Chapter7_ConsoleLogs {
    EdgeDriver driver;
    ChromeDriver driver;
    DevTools devTools;
    @BeforeClass
    public void setUp(){

        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void viewBrowserConsoleLogs(){
        // Get The DevTools & Create A Session
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable The Console Logs
        devTools.send(Log.enable());

        // Add A Listener For The Logs
        devTools.addListener(Log.entryAdded(), logEntry -> {
            System.out.println("----------");
            System.out.println("Level: " + logEntry.getLevel());
            System.out.println("Text: " + logEntry.getText());
            System.out.println("Broken URL: " + logEntry.getUrl());
        });

        // Load The AUT
        driver.get("http://the-internet.herokuapp.com/broken_images");
    }
    //GEOLOCATION
    @Test
    public void mockGeoLocation_executeCDPCommand(){
        Map coordinates = new HashMap()
        {{
            put("latitude", 32.746940);
            put("longitude", -97.092400);
            put("accuracy", 1);
        }};
        driver.executeCdpCommand(
                "Emulation.setGeolocationOverride", coordinates);
        driver.get("https://where-am-i.org/");

    }
    @Test
    public void mockGeoLocation_DevTools(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(52.5043),
                Optional.of(13.4501),
                Optional.of(1)));
        driver.get("https://my-location.org/");
    }

    @Test
    public void enableSlowRexJonesII(){
        devTools.createSession();
        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(
                false,
                150,
                2500,
                2000,
                Optional.of(ConnectionType.CELLULAR3G)));
        driver.get("https://rexjones2.com");
        System.out.println("Enable Slow Network: " + driver.getTitle());
    }

    @Test
    public void doNotEnableRexJonesII(){
        driver.get("https://linkedin.com");
        System.out.println("Do Not Enable Network: " + driver.getTitle());

    }
}
