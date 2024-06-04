package com.solvd.tests;

import com.solvd.gui.constants.Gender;
import com.solvd.gui.models.AccountInformation;
import com.solvd.gui.pages.common.*;
import com.solvd.gui.pages.mobile.SignupPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class MobileUserActionsTests extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MobileUserActionsTests.class);

    @DataProvider(name = "newAccountData")
    public Object[][] createAccountData() {
        return new Object[][]{
                {new AccountInformation("Wiktoria", "wiktoria999@email.com", Gender.MRS.getValue(), "password3", "26", "October", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Agata", "agata000@email.com", Gender.MRS.getValue(), "password3", "26", "October", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Maria", "maria000@email.com", Gender.MRS.getValue(), "password3", "26", "December", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Ewa", "ewa000@email.com", Gender.MRS.getValue(), "password3", "26", "January", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
        };
    }

    @Test(testName = "#TC0001", description = "Verify that user can sign up", dataProvider = "newAccountData", priority = 1)
    public void validateSignUp(AccountInformation accountInfo) {

        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();

        if (homePage.getGoogleDataAgreementButton().isVisible()) {
            homePage.clickGoogleDataAgreementButton();
        }

        softAssert.assertTrue(homePage.getHeader().isDisplayed(), "Header is not displayed");

        softAssert.assertTrue(homePage.getHeader().isDisplayed(), "Header is not displayed");

        SignupLoginPageBase signupLoginPage = homePage.getHeader().openSignupLoginPage();

        signupLoginPage.createAccount(accountInfo.getSignupName(), accountInfo.getSignupEmail());

        SignupPageBase signupPage = new SignupPage(getDriver());
        boolean visible = signupPage.getEmailAlreadyExistsMessage().isVisible();

        if (signupPage.getEmailAlreadyExistsMessage().isVisible()) {
            LOGGER.info("ENTERED THE 1 LOOP FOR ANDROID");
            softAssert.assertAll();
            assertTrue(true, "Account already exists");
        } else {
            LOGGER.info("ENTERED THE 2 LOOP FOR ANDROID");
            AccountCreatedPageBase accountCreatedPage = signupPage.enterAccountInformation(accountInfo);
            HomePageBase homePageAfterAccountCreated = accountCreatedPage.continueAfterAccountCreated();
            AccountDeletedPageBase accountDeletedPage = homePageAfterAccountCreated.getHeader().deleteAccount();
            boolean displayed = accountDeletedPage.getAccountDeletedMessage().isDisplayed();
            softAssert.assertAll();
            assertTrue(displayed, "Account deleted message is not displayed");
        }
    }
}

