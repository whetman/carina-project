package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    @FindBy(xpath = "(//p[@class='fc-button-label'])[1]")
    private ExtendedWebElement googleDataAgreementButton;

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String addRandomProductToCart();

    public abstract ItemPageBase viewRandomProductInformation();

    public abstract CartPageBase goToCart();

    public void clickGoogleDataAgreementButton() {
        LOGGER.info("clickGoogleDataAgreementButton()");
        getGoogleDataAgreementButton().click();
    }

    public HomePageBase login(String email, String password) {
        LOGGER.info("login(" + email + ")");
        SignupLoginPageBase signupLoginPageBase = getHeader().openSignupLoginPage();
        HomePageBase loggedHomePage = signupLoginPageBase.loginToAccount(email, password);
        return loggedHomePage;
    }

    public ExtendedWebElement getGoogleDataAgreementButton() {
        LOGGER.info("getGoogleDataAgreementButton()");
        return googleDataAgreementButton;
    }
}
