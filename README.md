# Setup Details
- I used eclipse for the cucumber so first i installed the **cucumber-eclipse-plugin-1.0.0-SNAPSHOT**.
- Next For parallel execution I used **maven-surefire-plugin** and created a runner class in which step definitions were glued, and features (cucumber) were taken for execution of two feature files in parallel.
- Used selenium added dependecy to pom.xml.
# Test Cases and their steps
homepage(): Navigates to the Weather Shopper homepage.

sunscreen_shopper_homepage(): Navigates to the Sunscreens page on Weather Shopper.

moisturizer_homepage(): Navigates to the Moisturizers page on Weather Shopper.

cart_homepage(): Navigates to the Cart page on Weather Shopper.

i_check_the_temperature(): Checks the temperature displayed on the homepage.

i_shop_for_moisturizers_if_the_temperature_is_below_19(): Directs the user to shop for moisturizers if the temperature is below 19°C.

i_shop_for_sunscreens_if_the_temperature_is_above_34(): Directs the user to shop for sunscreens if the temperature is above 34°C.

i_should_be_on_the_moisturizers_page(): Verifies that the user is on the Moisturizers page.

i_should_be_on_the_sunscreens_page(): Verifies that the user is on the Sunscreens page.

i_add_the_least_expensive_sunscreen_with_spf_50_to_the_cart(): Adds the least expensive sunscreen with SPF 50 to the cart.

i_add_the_least_expensive_sunscreen_with_spf_30_to_the_cart(): Adds the least expensive sunscreen with SPF 30 to the cart.

the_cart_should_contain_two_sunscreens(): Verifies that the cart contains two sunscreens.

i_verify_the_items_in_the_cart(): Checks the number of items in the cart.

i_proceed_to_checkout_with_stripe_test_card_numbers(): Proceeds to checkout using Stripe test card details.

the_payment_should_be_successful_or_fail_by_design(): Verifies the outcome of the payment (success or failure).

i_add_the_least_expensive_moisturizer_containing_aloe_to_the_cart(): Adds the cheapest moisturizer containing Aloe to the cart.

i_add_the_least_expensive_moisturizer_containing_almond_to_the_cart(): Adds the cheapest moisturizer containing Almond to the cart.

the_cart_should_contain_two_moisturizers(): Verifies that the cart contains two moisturizers.

# Instructions and configurations for integrating the solution with Selenium Grid
1. Download the Selenium Server.
2. Put server in folder where project in located, After that open terminal and execute the command **java -jar selenium-server-4.22.0.jar standalone** version can vary.
3. Now when the server runs it will show URL like this "http://192.168.56.1:4444", Now this can be used in steps class as this private static final String HUB_URL = "http://192.168.56.1:4444";
