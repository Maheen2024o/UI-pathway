package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");
    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }
    public void selectFromDropdown(String option) {
        //Select dropdownElement = new Select(driver.findElement(dropdown));
        //dropdownElement.selectByVisibleText(option);
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOption() {
        //we can use loop too for each element
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }

}
