# Code Execution requirements:
- Adding plugins to pom.xml
- Installing the selenium-server-4.22.0.jar to build up the selenium grid by using command **"java -jar selenium-server-4.22.0.jar standalone"**.
- The chrome driver exe to check the automated tests.
# Assertions Used:
### Test Case: successfulSignIn
- assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
  
**Reasoning:** This assertion verifies that after a successful login, the user is redirected to the inventory page. The expected URL is checked to ensure the login was successful and the user reached the correct destination.
### Test Case: addItemToCartAndRemoveFromProductsPage
- assertEquals("1", driver.findElement(By.className("shopping_cart_badge")).getText());
  
**Reasoning:** This assertion checks that after adding an item to the cart, the cart badge displays "1", indicating one item has been added.
- assertTrue(driver.findElements(By.className("shopping_cart_badge")).isEmpty());

**Reasoning:** This assertion verifies that after removing the item from the cart, the cart badge is no longer displayed, indicating the cart is empty.
- assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed());

**Reasoning:** This assertion checks that the "Add to Cart" button for the item is displayed again after the item is removed, indicating the item can be added again.
### Test Case: addItemToCartAndRemoveFromCheckoutPage


