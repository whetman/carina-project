package com.solvd.gui.pages.mobile;

import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SignupLoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignupLoginPageBase.class)
public class SignupLoginPage extends SignupLoginPageBase implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupLoginPage.class);

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void createAccount(String name, String email) {
        LOGGER.info("createAccount() " + name + ", " + email);
        getNameBar().type(name);
        getEmailSignupBar().type(email);
        getSignupButton().click();
        getSignupButton().click();
    }

    @Override
    public HomePageBase login(String email, String password) {
        LOGGER.info("login() " + email + ", " + password);
        getEmailField().type(email);
        getPasswordField().type(password);
        getLoginButton().click();
        return initPage(getDriver(), HomePageBase.class);
    }

}
