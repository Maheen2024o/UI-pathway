package baseTests;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

public class testShadowDomWatir {
    private WebDriver driver;
    protected HomePage HomePage;
    @Test
    public void testDomWatir () {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://watir.com/examples/shadow_dom.html");

        HomePage = new HomePage(driver);//provided handle to test layer to frame layer

        assertEquals (HomePage.getShadowDomText (), "some text");
        assertEquals (HomePage.getNestedShadowText (),"nested text");
        assertEquals (HomePage.getNestedText (), "nested text");
        assertEquals (HomePage.getNestedTextUsingJSExecutor (), "nested text");
    }
}
