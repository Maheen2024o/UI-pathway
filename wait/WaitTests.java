package wait;

import Base.baseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends baseTests {
    @Test
    public void testWaitUntilHidden()
    {
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStartButton();
        assertEquals(loadingPage.getLoadedText(),"Hello World!","Loaded text incorrect");

    }

}
