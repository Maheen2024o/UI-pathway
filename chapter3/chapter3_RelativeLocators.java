package chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class chapter3_RelativeLocators {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test() {
        WebElement loginPanel = driver.findElement(By.id("logInPanelHeading"));
        WebElement credentials = driver.findElement(with( By.tagName("span")).above(loginPanel));
        System.out.println(credentials.getText());
    }
    @Test
    public void test2() {
        List<WebElement> allSocialMedia = (List<WebElement>) driver.findElement(with( By.tagName("img")).near(By.id("footer")));

        for(WebElement element : allSocialMedia) {
            System.out.println(element.getAttribute("alt"));
        }
    }
    @Test
    public void test3() {
        WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get("http://automationpractice.com/index.php?controller=prices-drop");
        System.out.println("Title: " + driver.getTitle());


    }
    @Test
    public void test4() {
        driver.manage().window().maximize();
        driver.switchTo().newWindow(WindowType.TAB)
                .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        System.out.println("Title: " + driver.getTitle());

        // Work In The New Window Or Tab
        driver.findElement(By.id("email_create")).sendKeys("Selenium4@TAU.com");
        driver.findElement(By.id("SubmitCreate")).click();

        // Get The Window ID Handles
        Set<String> allWindowTabss= driver.getWindowHandles();
        Iterator<String> iterate = allWindowTabss.iterator();
        String mainFirstWindow = iterate.next();

        // Switch & Work In The Main Window Or Tab
        driver.switchTo().window(mainFirstWindow);
        driver.manage().window().maximize();
        driver.findElement(By.id("search_query_top")).sendKeys("Shirt");
        driver.findElement(By.name("submit_search")).click();
        System.out.println("Title: " + driver.getTitle());
    }

}
