package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.SignupLoginPageBase;
import com.solvd.gui.pages.common.SignupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignupLoginPageBase.class)
public class SignupLoginPage extends SignupLoginPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupLoginPage.class);

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

    @FindBy(xpath = "//form[contains(@action, '/signup')]/p")
    private ExtendedWebElement emailAlreadyExistsMessage;

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignupPageBase createAccount(String name, String email) {
        LOGGER.info("createAccount() " + name + ", " + email);
        nameBar.type(name);
        emailSignupBar.type(email);
        signupButton.click();
        return initPage(getDriver(), SignupPageBase.class);
    }


}
