package Alerts;

import Base.baseTests;
import Pages.AlertsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends baseTests {
    @Test
    public void testAcceptAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResult(),"You successfuly clicked an alert","Alert text incorrect");


    }
    @Test
    public void testGetTextFromAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirmationAlert();
        String text = alertsPage.getResult();
        alertsPage.alert_clickToDimiss();
        assertEquals(text,"I am a JS Confirm","Alert text incorrect");

    }
    @Test
    public void testSetInputInAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPromptAlert();
        String text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResult(),"You entered: " + text,"Results text incorrect");

    }

}
