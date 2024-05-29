package com.solvd.gui.pages.mobile;

import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SignupLoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignupLoginPageBase.class)
public class SignupLoginPage extends SignupLoginPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupLoginPage.class);

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void createAccount(String name, String email) {
        LOGGER.info("createAccount() " + name + ", " + email);
        nameBar.type(name);
        emailSignupBar.type(email);
        signupButton.click();
    }

    @Override
    public HomePageBase login(String email, String password) {
        LOGGER.info("login() " + email + ", " + password);
        emailField.type(email);
        passwordField.type(password);
        loginButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }

}
