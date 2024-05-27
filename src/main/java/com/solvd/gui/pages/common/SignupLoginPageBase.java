package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class SignupLoginPageBase extends AbstractPage {

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

    @FindBy(xpath = "//form[contains(@action, '/signup')]/p")
    protected ExtendedWebElement emailAlreadyExistsMessage;

    public SignupLoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignupPageBase createAccount(String name, String email);

    public abstract HomePageBase login(String email, String password);

}
