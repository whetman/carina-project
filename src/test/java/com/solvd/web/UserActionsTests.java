package com.solvd.web;

import com.solvd.gui.constants.Gender;
import com.solvd.gui.models.AccountInformation;
import com.solvd.gui.models.PaymentInformation;
import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.CheckoutPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.PaymentDonePageBase;
import com.solvd.gui.pages.common.PaymentPageBase;
import com.solvd.gui.pages.common.SignupPageBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class UserActionsTests extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserActionsTests.class);

    @DataProvider(name = "newAccountData", parallel = true)
    public Object[][] createAccountData() {
        return new Object[][]{
                {new AccountInformation("Agata", "agata1@email.com", Gender.MRS.getValue(), "password3", "26", "October", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Maria", "maria9991@email.com", Gender.MRS.getValue(), "password3", "26", "December", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Ewa", "ewa1@email.com", Gender.MRS.getValue(), "password3", "26", "January", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
        };
    }

    @DataProvider(name = "accountData", parallel = true)
    public Object[][] loginData() {
        return new Object[][]{
                {"tadeusz@email.com", "password1", new PaymentInformation("Tadeusz Kowalski", "999999666666", "000", "12", "2300")},
                {"jolanta@email.com", "password2", new PaymentInformation("Jolanta Kowalska", "111222333444", "001", "11", "2036")},
                {"wiktoria999@email.com", "password1", new PaymentInformation("Wik wik", "777888999555", "002", "10", "2080")},
        };
    }

    @Test(testName = "#TC0001", description = "Verify that user can sign up", dataProvider = "newAccountData", priority = 1)
    public void validateSignUp(AccountInformation accountInfo) {

        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();

        SignupPageBase signupPageBase = homePage.signUp(accountInfo.getSignupName(), accountInfo.getSignupEmail());
        signupPageBase.enterAccountInformation(accountInfo);


        softAssert.assertAll();
    }

    @Test(testName = "#TC0002", description = "Verify that logged user can add the product to the cart and buy it", dataProvider = "accountData", priority = 0)
    public void verifyAddingProductsAndBuying(String email, String password, PaymentInformation paymentInformation) {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();

        homePage.login(email, password);

        String productAdded = homePage.addRandomProductToCart();
        String productAddedTwo = homePage.addRandomProductToCart();
        String productAddedThree = homePage.addRandomProductToCart();

        CartPageBase cartPageBase = homePage.goToCart();

        //todo create a stream that make this asserts
        String cartItemDescriptionOne = cartPageBase.getCartItemDescription(0);
        String cartItemDescriptionTwo = cartPageBase.getCartItemDescription(1);
        String cartItemDescriptionThree = cartPageBase.getCartItemDescription(2);

        softAssert.assertTrue(cartItemDescriptionOne.contains(productAdded), "Products are not the same");
        softAssert.assertTrue(cartItemDescriptionTwo.contains(productAddedTwo), "Products are not the same");
        softAssert.assertTrue(cartItemDescriptionThree.contains(productAddedThree), "Products are not the same");

        CheckoutPageBase checkoutPage = cartPageBase.buyProducts();
        boolean areAddressesCorrect = checkoutPage.areAddressesCorrect();

        softAssert.assertTrue(areAddressesCorrect, "Billing address and delivery address are not the same");

        PaymentPageBase paymentPage = checkoutPage.placeOrder();
        PaymentDonePageBase paymentDonePageBase = paymentPage.enterPaymentDetailsAndContinue(
                paymentInformation.getNameOnCard(),
                paymentInformation.getCardNumber(),
                paymentInformation.getCvcNumber(),
                paymentInformation.getExpirationMonth(),
                paymentInformation.getExpirationYear());

        softAssert.assertAll();

        assertTrue(paymentDonePageBase.getInvoiceButton().isDisplayed(), "Invoice button is not displayed");
    }
}
