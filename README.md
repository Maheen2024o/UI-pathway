# Code Execution requirements:
- Adding plugins to pom.xml
- Installing the selenium-server-4.22.0.jar to build up the selenium grid by using command **"java -jar selenium-server-4.22.0.jar standalone"**.
- The chrome driver exe to check the automated tests.
# Assertions Used:
### Test Case: successfulSignIn
- assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
**Reasoning:** This assertion verifies that after a successful login, the user is redirected to the inventory page. The expected URL is checked to ensure the login was successful and the user reached the correct destination.



