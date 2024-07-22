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
- assertEquals("1", driver.findElement(By.className("shopping_cart_badge")).getText());

**Reasoning:** This assertion ensures that after adding an item to the cart, the cart badge displays "1".
- assertTrue(driver.findElements(By.className("shopping_cart_badge")).isEmpty());

**Reasoning:** This assertion checks that after removing the item during the checkout process, the cart badge is no longer displayed, indicating the cart is empty.
### Test Case: addItemToCartAndRemoveFromProductDetailsPage
- assertEquals("1", driver.findElement(By.className("shopping_cart_badge")).getText());

**Reasoning:** This assertion verifies that after adding an item to the cart from the product details page, the cart badge displays "1".

- assertTrue(driver.findElements(By.className("shopping_cart_badge")).isEmpty());

**Reasoning:** This assertion checks that after removing the item from the cart, the cart badge is no longer displayed, indicating the cart is empty.

- assertTrue(driver.findElement(By.id("add-to-cart")).isDisplayed());
  
**Reasoning:** This assertion ensures that the "Add to Cart" button is displayed again after removing the item, indicating the item can be added again.
### Test Case: buyItems
- assertTrue(driver.getCurrentUrl().contains("checkout-complete"));

**Reasoning:** This assertion verifies that the user has successfully completed the purchase and reached the checkout complete page.
### Test Case: addItemToCartLogoutAndVerifyCartPersistence
- assertEquals("1", driver.findElement(By.className("shopping_cart_badge")).getText());
  
**Reasoning:** This assertion checks that after adding an item to the cart, the cart badge displays "1".
- assertEquals("1", driver.findElement(By.className("shopping_cart_badge")).getText());
  
**Reasoning:** This assertion verifies that after logging out and logging back in, the item remains in the cart, and the cart badge still displays "1", indicating cart persistence.
### Test Case: verifySortingOptions
- assertEquals(sortedPrices, actualPrices);

**Reasoning:** This assertion checks that the prices of items are sorted correctly according to the selected sorting option (ascending or descending). It ensures the actual prices displayed on the page match the expected sorted prices.

- assertEquals(sortedValues, actualValues);
  
**Reasoning:** This assertion verifies that the names of items are sorted correctly according to the selected sorting option (alphabetically ascending or descending). It ensures the actual item names displayed on the page match the expected sorted names.


