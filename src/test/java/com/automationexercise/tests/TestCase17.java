package com.automationexercise.tests;

import com.automationexercise.pages.CartPage;
import com.automationexercise.utils.Util;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Place Order")
public class TestCase17 extends TestBasic {

    String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";

    @Test(description = "Test Case 17: Remove Products From Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Remove Products From Cart")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Add products to cart
            5. Click 'Cart' button
            6. Verify that cart page is displayed
            7. Click 'X' button corresponding to particular product
            8. Verify that product is removed from the cart""")
    public void removeProductsFromCart() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase14.verifyAccountCreatedAndClickContinueButton(name, email);
        TestCase14.verifyLoggedInAsUsernameAtTop(name);
        TestCase14.verifyThatCartPageIsDisplayed();
        new CartPage(getDriver()).proceedToCheckoutButtonClick();
        TestCase14.verifyAddressDetailsAndReviewYourOrder();
        TestCase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
        TestCase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
    }
}
