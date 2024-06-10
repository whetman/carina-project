package com.solvd.gui.pages.mobile;

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
        LOGGER.info("SignupLoginPage()");
    }

}
