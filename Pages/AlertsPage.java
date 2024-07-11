package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {
    private WebDriver driver;
    private By results = By.id("result");
    private By triggerAlertabutton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private By triggerConfirmationButton = By.xpath(".//button[text()='Click for JS Confirm']");
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void triggerAlert() {
        driver.findElement(triggerAlertabutton).click();
    }
    public void triggerConfirmationAlert() {
        driver.findElement(triggerConfirmationButton).click();
    }
    public void triggerPromptAlert() {
        driver.findElement(triggerPromptButton).click();
    }
    public void  acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void alert_clickToDimiss(){
        driver.switchTo().alert().dismiss();
    }
    public void alert_setInput(String input){
        driver.switchTo().alert().sendKeys(input);
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
    public String getResult()
    {
        return driver.findElement(results).getText();
    }
}
