package com.solvd.web;

import com.solvd.gui.constants.Gender;
import com.solvd.gui.models.AccountInformation;
import com.solvd.gui.models.PaymentInformation;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SignupPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserActionsTests implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserActionsTests.class);

    @DataProvider(name = "newAccountData", parallel = true)
    public Object[][] createAccountData() {
        return new Object[][]{
                {new AccountInformation("Agata", "agata@email.com", Gender.MRS.getValue(), "password3", "26", "4", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Maria", "maria999@email.com", Gender.MRS.getValue(), "password3", "26", "4", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Ewa", "ewa@email.com", Gender.MRS.getValue(), "password3", "26", "4", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
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

        //how to make it one method
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();

        SignupPageBase signupPageBase = homePage.signUp(accountInfo.getSignupName(), accountInfo.getSignupEmail());
        signupPageBase.enterAccountInformation(accountInfo);



        softAssert.assertAll();
    }

    @Test(testName = "#TC0002", description = "Verify that logged user can add the product to the cart and buy it", dataProvider = "accountData", priority = 0)
    public void verifyAddingProductsAndBuying(String email, String password, PaymentInformation paymentInformation) {
        SoftAssert softAssert = new SoftAssert();

        //how to make it one method
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();

        homePage.addRandomProductToCart();
        homePage.addRandomProductToCart();
        homePage.addRandomProductToCart();

        homePage.goToCart();



        softAssert.assertAll();
    }
}
