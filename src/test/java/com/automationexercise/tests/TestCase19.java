package com.automationexercise.tests;

import com.automationexercise.pages.CartPage;
import com.automationexercise.utils.Util;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Place Order")
public class TestCase19 extends TestBasic {

    String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";

    @Test(description = "Test Case 19: View & Cart Brand Products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("View & Cart Brand Products")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify that Brands are visible on left side bar
            5. Click on any brand name
            6. Verify that user is navigated to brand page and brand products are displayed
            7. On left side bar, click on any other brand link
            8. Verify that user is navigated to that brand page and can see products""")
    public void viewCartBrandProducts() throws IOException, ParseException {
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
