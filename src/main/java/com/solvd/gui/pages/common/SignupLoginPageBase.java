package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SignupLoginPageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupLoginPageBase.class);

    @FindBy(xpath = "//input[@name='name']")
    private ExtendedWebElement nameBar;

    @FindBy(xpath = "//form[contains(@action, 'signup')]//input[@name = 'email']")
    private ExtendedWebElement emailSignupBar;

    @FindBy(xpath = "//form[contains(@action, 'signup')]//button")
    private ExtendedWebElement signupButton;

    @FindBy(xpath = "//form[contains(@action, 'login')]//input[@name='email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//form[contains(@action, 'login')]//button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'login')]")
    private ExtendedWebElement loginForm;

    public SignupLoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void createAccount(String name, String email);

    public abstract HomePageBase login(String email, String password);

    public ExtendedWebElement getNameBar() {
        LOGGER.info("getNameBar()");
        return nameBar;
    }

    public ExtendedWebElement getEmailSignupBar() {
        LOGGER.info("getEmailSignupBar()");
        return emailSignupBar;
    }

    public ExtendedWebElement getSignupButton() {
        LOGGER.info("getSignupButton()");
        return signupButton;
    }

    public ExtendedWebElement getEmailField() {
        LOGGER.info("getEmailField()");
        return emailField;
    }

    public ExtendedWebElement getPasswordField() {
        LOGGER.info("getPasswordField()");
        return passwordField;
    }

    public ExtendedWebElement getLoginButton() {
        LOGGER.info("getLoginButton()");
        return loginButton;
    }

    public ExtendedWebElement getLoginForm() {
        LOGGER.info("getLoginForm()");
        return loginForm;
    }

}
