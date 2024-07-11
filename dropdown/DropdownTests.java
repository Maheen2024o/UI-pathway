package dropdown;

import Base.baseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends baseTests {
    @Test
    public void testSelectOption() {
        var dropDownPage =  homePage.clickDropDown();
        String option = "Option 1";
        dropDownPage.selectFromDropdown("Option 1");
        var selectOptions = dropDownPage.getSelectedOption();
        assertEquals(selectOptions.size(), 1,"Incorrect number of selections");
        assertTrue(selectOptions.contains(option),"Option not selected");
    }

}
