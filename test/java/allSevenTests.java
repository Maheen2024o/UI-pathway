import com.aventstack.extentreports.ExtentTest;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class allSevenTests {
    protected WebDriver driver;
    private static final String HUB_URL = "http://172.16.2.63:4444";
    private static ExtentTest testReport;


    @BeforeAll
    public static void setupExtent() {
        Report.init();
    }
    @AfterEach
    public void tearDown() {
        Report.flush();
    }


    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = initializeDriver(Config.getBrowser());

        // Read data from JSON file
        JSONObject userData = Json.readUserData("C:\\Users\\Maheen\\IdeaProjects\\Junit\\src\\test\\java\\testdata.json");
        String username = (String) userData.get("username");
        String password = (String) userData.get("password");
        login(driver,username,password);
    }

    private WebDriver initializeDriver(String browser) throws MalformedURLException {
        if (browser.equals("chrome")) {
            return new RemoteWebDriver(new URL(HUB_URL), new ChromeOptions());
        } else if (browser.equals("firefox")) {
            return new RemoteWebDriver(new URL(HUB_URL), new FirefoxOptions());
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }


    @Tag("loginsuccessful")
    @Test
    public void successfulSignIn() throws MalformedURLException {
        testReport = Report.createTest("Verify successful SignIn");
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

        driver.quit();
    }

    //add to cart and remove
    @Tag("addItemToCartAndRemoveFromProductsPage")
    @Test
    public void addItemToCartAndRemoveFromProductsPage() throws MalformedURLException {
        //WebDriver driver = initializeDriver("firefox");
        testReport = Report.createTest("Verify add Item To Cart And Remove From Products Page");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        assertEquals("1", driver.findElement(By.className("shopping_cart_badge")).getText());

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        assertTrue(driver.findElements(By.className("shopping_cart_badge")).isEmpty());
        assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed());

        driver.quit();
    }


    private void login(WebDriver driver, String username, String password) {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
    // Add Items to Cart and Remove Them from the Checkout Page
    @Tag("addItemToCartAndRemoveFromCheckoutPage")
    @Test
    public void addItemToCartAndRemoveFromCheckoutPage() {

        testReport = Report.createTest("Verify add Item To Cart And Remove From Checkout Page");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        assertEquals("1", driver.findElement(By.className("shopping_cart_badge")).getText());

        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("cancel")).click();
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        assertTrue(driver.findElements(By.className("shopping_cart_badge")).isEmpty());
    }
    @Tag("addItemToCartAndRemoveFromProductDetailsPage")
    @Test
    public void addItemToCartAndRemoveFromProductDetailsPage() throws MalformedURLException {
        testReport = Report.createTest("Verify add Item To Cart And Remove From Product Details Page");
        // Navigate to product details page
        driver.findElement(By.className("inventory_item_name")).click();

        // Add item to cart
        driver.findElement(By.id("add-to-cart")).click();
        assertEquals("1", driver.findElement(By.className("shopping_cart_badge")).getText());

        driver.findElement(By.id("remove")).click();

        // Verify cart icon and "Add to Cart" option
        assertTrue(driver.findElements(By.className("shopping_cart_badge")).isEmpty());
        assertTrue(driver.findElement(By.id("add-to-cart")).isDisplayed());


        // Quit WebDriver
        driver.quit();
    }
    @Tag("buyItems")
    @Test
    public void buyItems() throws MalformedURLException {
        testReport = Report.createTest("buyItems");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        // Proceed to checkout
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.className("checkout_button")).click();

        // Enter shipping information (example, adjust as per your application's actual flow)
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.className("cart_button")).click();

        // Complete the purchase
        driver.findElement(By.className("cart_button")).click();


        assertTrue(driver.getCurrentUrl().contains("checkout-complete"));

        // Quit WebDriver
        driver.quit();
    }


    @Tag("addItemToCartLogoutAndVerifyCartPersistence")
    @Test
    public void addItemToCartLogoutAndVerifyCartPersistence() throws MalformedURLException {

        testReport = Report.createTest("Verify add Item To Cart Logout And Verify Cart Persistence");
        // Read data from JSON file
        JSONObject userData = Json.readUserData("C:\\Users\\Maheen\\IdeaProjects\\Junit\\src\\test\\java\\testdata.json");
        String username = (String) userData.get("username");
        String password = (String) userData.get("password");



        // Perform login
        login(driver, username, password);


        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        assertEquals("1", driver.findElement(By.className("shopping_cart_badge")).getText());

        //logout
        driver.findElement(By.id("react-burger-menu-btn")).click();
        //driver.findElement(By.id("logout_sidebar_link")).click();
        // Click on the logout link
        WebElement logoutLink = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutLink.click();


        login(driver, username, password);


        // Verify cart persistence
        assertEquals("1", driver.findElement(By.className("shopping_cart_badge")).getText());

        driver.quit();
    }
    @Tag("verifySortingOptions")
    @Test
    public void verifySortingOptions() throws MalformedURLException {
        // Read data from JSON file
        testReport = Report.createTest("Verify Sorting Options Test");
        JSONObject userData = Json.readUserData("C:\\Users\\Maheen\\IdeaProjects\\Junit\\src\\test\\java\\testdata.json");
        String username = (String) userData.get("username");
        String password = (String) userData.get("password");
        login(driver, username, password);
        verifySortingOption("az", By.className("inventory_item_name"), true);
        verifySortingOption("za", By.className("inventory_item_name"), false);
        verifySortingOption("lohi", By.className("inventory_item_price"), true);
        verifySortingOption("hilo", By.className("inventory_item_price"), false);



        driver.quit();
    }
    private void verifySortingOption(String optionValue, By locator, boolean ascending) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));

        WebElement sortingDropdown = driver.findElement(By.className("product_sort_container"));
        sortingDropdown.findElement(By.xpath("//option[@value='" + optionValue + "']")).click();

        verifySorting(locator, ascending);
    }
    private void verifySorting(By locator, boolean ascending) {
        List<WebElement> elements = driver.findElements(locator);
        List<String> actualValues = elements.stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> sortedValues = new ArrayList<>(actualValues);
        if (locator.equals(By.className("inventory_item_price"))) {
            List<Double> sortedPrices = sortedValues.stream()
                    .map(value -> Double.parseDouble(value.replace("$", "")))
                    .sorted(ascending ? Comparator.naturalOrder() : Comparator.reverseOrder())
                    .collect(Collectors.toList());
            List<Double> actualPrices = actualValues.stream()
                    .map(value -> Double.parseDouble(value.replace("$", "")))
                    .collect(Collectors.toList());
            assertEquals(sortedPrices, actualPrices);
        } else {
            Collections.sort(sortedValues, ascending ? String::compareTo : Comparator.reverseOrder());
            assertEquals(sortedValues, actualValues);
        }
    }




}
