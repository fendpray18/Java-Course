package com.automationexercise.tests;

import com.automationexercise.pages.CartPage;
import com.automationexercise.utils.Util;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Place Order")
public class TestCase18 extends TestBasic {

    String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";

    @Test(description = "Test Case 18: View Category Products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("View Category Products")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that categories are visible on left side bar
            4. Click on 'Women' category
            5. Click on any category link under 'Women' category, for example: Dress
            6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
            7. On left side bar, click on any sub-category link of 'Men' category
            8. Verify that user is navigated to that category page""")
    public void viewCategoryProducts() throws IOException, ParseException {
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
