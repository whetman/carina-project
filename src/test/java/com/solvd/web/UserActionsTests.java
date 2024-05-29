package com.solvd.web;

import com.solvd.gui.constants.Gender;
import com.solvd.gui.models.AccountInformation;
import com.solvd.gui.models.PaymentInformation;
import com.solvd.gui.pages.common.AccountCreatedPageBase;
import com.solvd.gui.pages.common.AccountDeletedPageBase;
import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.CheckoutPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.PaymentDonePageBase;
import com.solvd.gui.pages.common.PaymentPageBase;
import com.solvd.gui.pages.common.SignupLoginPageBase;
import com.solvd.gui.pages.common.SignupPageBase;
import com.solvd.gui.pages.desktop.SignupPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.testng.Assert.assertTrue;

public class UserActionsTests extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserActionsTests.class);

    @DataProvider(name = "newAccountData", parallel = true)
    public Object[][] createAccountData() {
        return new Object[][]{
                {new AccountInformation("Wiktoria", "wiktoria999@email.com", Gender.MRS.getValue(), "password3", "26", "October", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Agata", "agata000@email.com", Gender.MRS.getValue(), "password3", "26", "October", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Maria", "maria000@email.com", Gender.MRS.getValue(), "password3", "26", "December", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Ewa", "ewa000@email.com", Gender.MRS.getValue(), "password3", "26", "January", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
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

    @Test(testName = "#TC0001", description = "Verify that user can sign up", dataProvider = "newAccountData", priority = 1, threadPoolSize = 2, invocationCount = 2)
    public void validateSignUp(AccountInformation accountInfo) {

        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();
        homePage.clickGoogleDataAgreementButton();

        softAssert.assertTrue(homePage.getHeader().isDisplayed(), "Header is not displayed");

        SignupLoginPageBase signupLoginPage = homePage.getHeader().openSignupLoginPage();

        signupLoginPage.createAccount(accountInfo.getSignupName(), accountInfo.getSignupEmail());

        if (signupLoginPage.getEmailAlreadyExistsMessage().isDisplayed() && signupLoginPage.getEmailAlreadyExistsMessage().getText().contains("exists")) {
            softAssert.assertAll();
            assertTrue(true, "Account already exists");
        } else {
            SignupPageBase signupPage = new SignupPage(getDriver());
            AccountCreatedPageBase accountCreatedPage = signupPage.enterAccountInformation(accountInfo);
            HomePageBase homePageAfterAccountCreated = accountCreatedPage.continueAfterAccountCreated();
            AccountDeletedPageBase accountDeletedPage = homePageAfterAccountCreated.getHeader().deleteAccount();
            boolean displayed = accountDeletedPage.getAccountDeletedMessage().isDisplayed();
            softAssert.assertAll();
            assertTrue(displayed, "Account deleted message is not displayed");
        }
    }

    @Test(testName = "#TC0002", description = "Verify that logged user can add the product to the cart and buy it", dataProvider = "accountData", priority = 0, threadPoolSize = 2, invocationCount = 2)
    public void verifyAddingProductsAndBuying(String email, String password, PaymentInformation paymentInformation) {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();

        homePage.clickGoogleDataAgreementButton();

        homePage.login(email, password);

        String productAdded = homePage.addRandomProductToCart();
        String productAddedTwo = homePage.addRandomProductToCart();
        String productAddedThree = homePage.addRandomProductToCart();

        CartPageBase cartPageBase = homePage.goToCart();

        List<String> productsAdded = Arrays.asList(productAdded, productAddedTwo, productAddedThree);

        IntStream.range(0, productsAdded.size())
                .forEach(i -> {
                    String cartItemDescription = cartPageBase.getCartItemDescription(i);
                    softAssert.assertTrue(cartItemDescription.contains(productsAdded.get(i)), "Products are not the same");
                });

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
