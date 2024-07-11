package Keys;

import Base.baseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeysTests extends baseTests {
    @Test
    public void testBackspace() {
        var keyPage = homePage.clickKeyPresse();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(),"You entered: BACK_SPACE");
    }
    @Test
    public void testPi() {
        var keyPage = homePage.clickKeyPresse();
        keyPage.enterPi();

    }

}
