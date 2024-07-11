package Pages;

import org.openqa.selenium.*;

import static java.sql.DriverManager.getDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public SearchContext expandRootElement (WebElement element) {

        SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor)driver).executeScript (
                "return arguments[0].shadowRoot", element);
        return shadowRoot;
    }

    public String getSomeText () {
        return driver.findElement(By.cssSelector ("#shadow_content > span"))
                .getText ();
    }

    public String getShadowDomText () {
        WebElement shadowHost = driver.findElement (By.id ("shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot ();
        String text = shadowRoot.findElement (By.cssSelector ("#shadow_content > span"))
                .getText ();
        return text;
    }

    public String getNestedShadowText () {
        WebElement shadowHost = driver.findElement (By.id ("shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot ();
        WebElement shadowContent = shadowRoot.findElement (By.cssSelector ("#nested_shadow_host"));
        SearchContext shadowRootTwo = shadowContent.getShadowRoot ();
        String nestedText = shadowRootTwo.findElement (By.cssSelector ("#nested_shadow_content > div")).getText ();
        return nestedText;
    }

    public String getNestedText() {
        WebElement nestedText = driver.findElement (By.id ("shadow_host")).getShadowRoot ()
                .findElement (By.cssSelector ("#nested_shadow_host")).getShadowRoot ()
                .findElement (By.cssSelector ("#nested_shadow_content > div"));
        return nestedText.getText ();
    }

    public String getNestedTextUsingJSExecutor () {
        WebElement shadowHost = driver.findElement (By.id ("shadow_host"));
        SearchContext shadowRootOne = expandRootElement (shadowHost);
        WebElement nestedShadowHost = shadowRootOne.findElement (By.cssSelector ("#nested_shadow_host"));
        SearchContext shadowRootTwo = expandRootElement (nestedShadowHost);
        return shadowRootTwo.findElement (By.cssSelector ("#nested_shadow_content > div"))
                .getText ();

    }
}
