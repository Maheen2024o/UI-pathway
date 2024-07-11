package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinvmce");
    private By decreaseIndentButton = By.id("#mceu_12 button");
    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clearTextArea()
    {
        switchToWysiwygEditorPage();
        driver.findElement(textArea).clear();
        switchToWysiwygEditorPage();
    }
    public void setTextArea(String text)
    {
        switchToWysiwygEditorPage();
        driver.findElement(textArea).sendKeys(text);

    }
    private void switchToWysiwygEditorPage() {
        driver.switchTo().frame(editorIframeId);
    }
    private void switchWysiwygToMainArea()
    {
        driver.switchTo().parentFrame();
    }
    public String getTextFromEditor()
    {
        switchToWysiwygEditorPage();
        String text = driver.findElement(textArea).getText();
        switchToWysiwygEditorPage();
        return text;

    }
    public void decreaseIndention()
    {
        driver.findElement(decreaseIndentButton).click();
    }

}
