package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    //private By formAuthenticationLink = By.linkText("Form Authentication");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication()
    {
        //driver.findElement(formAuthenticationLink).click();
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }
    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }
    public HoversPage clickHovers()
    {
        clickLink("Hovers");
        return new HoversPage(driver);

    }
    public ForgotPasswordPage clickForgotPassword() {
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }
    public void clickLink(String linkText)
    {
        driver.findElement(By.linkText(linkText)).click();
    }
    public KeyPressesPage clickKeyPresse()
    {
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }
    public HorizontalSliderPage clickHorizontalSlider()
    {
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }
    public AlertsPage clickJavaScriptAlerts()
    {
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }
    public WysiwygEditorPage clickIframe()
    {
        clickLink("Wysiwyg Editor Page");
        return new WysiwygEditorPage(driver);
    }
    public FramesPage clickframe()
    {
        clickLink("Frame click");
        return new FramesPage(driver);
    }
    public DynamicLoadingPage clickDynamicLoading()
    {
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }
    public LargeAndDeepDomPage clickLargeAndDeepDom()
    {
        clickLink("Large And Deep Dom");
        return new LargeAndDeepDomPage(driver);
    }

}
