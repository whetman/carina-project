package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class SignupLoginPageBase extends AbstractPageBase {

    @FindBy(xpath = "//input[@name='name']")
    protected ExtendedWebElement nameBar;

    @FindBy(xpath = "//form[contains(@action, 'signup')]//input[@name = 'email']")
    protected ExtendedWebElement emailSignupBar;

    @FindBy(xpath = "//form[contains(@action, 'signup')]//button")
    protected ExtendedWebElement signupButton;

    @FindBy(xpath = "//form[contains(@action, 'login')]//input[@name='email']")
    protected ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    protected ExtendedWebElement passwordField;

    @FindBy(xpath = "//form[contains(@action, 'login')]//button")
    protected ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'login')]")
    protected ExtendedWebElement loginForm;

    @FindBy(xpath = "//button[@type='submit']/preceding-sibling::p")
    protected ExtendedWebElement emailAlreadyExistsMessage;

    public SignupLoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void createAccount(String name, String email);

    public abstract HomePageBase login(String email, String password);

    public ExtendedWebElement getEmailAlreadyExistsMessage() {
        return emailAlreadyExistsMessage;
    }
}
