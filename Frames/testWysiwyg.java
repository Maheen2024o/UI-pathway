package Frames;
import Base.baseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class testWysiwyg extends baseTests {
     @Test
    public void testWysiwyg()
     {
        var editorPage= homePage.clickIframe();
        editorPage.clearTextArea();
        String text1 = "hello";
        String text2 = "world";
        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(),text1+text2,"Text from editor is incorrect");
     }
}
