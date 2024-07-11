package Base;

import Pages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

public class baseTests {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp()
    {

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");
        //driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(375,812));
        //WebElement inputsLinks = driver.findElement(By.linkText("Inputs"));
        //inputsLinks.click();
        homePage = new HomePage(driver);//provided handle to test layer to frame layer
        //System.out.println(driver.getTitle());
        //driver.quit();

    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
    @AfterMethod
    public void takeScreenshot(){

        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        try{
            Files.move(screenshot, new File("resources/screenshots/test.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /*public static void main(String[] args)
    {
        baseTests test= new baseTests();
        test.setUp();
    }*/
}
