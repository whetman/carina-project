package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SignupLoginPageBase;
import com.solvd.gui.pages.common.SignupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignupLoginPageBase.class)
public class SignupLoginPage extends SignupLoginPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupLoginPage.class);

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

    @Override
    public HomePageBase login(String email, String password) {
        LOGGER.info("login() " + email + ", " + password);
        emailField.type(email);
        passwordField.type(password);
        loginButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }

}
