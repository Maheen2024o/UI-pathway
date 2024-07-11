package javascript;

import Base.baseTests;
import org.testng.annotations.Test;

public class JavaScriptTests extends baseTests {
    @Test
    public void testScrollToTable() {
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

}
