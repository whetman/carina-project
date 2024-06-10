package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.SignupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignupPageBase.class)
public class SignupPage extends SignupPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupPage.class);

    public SignupPage(WebDriver driver) {
        super(driver);
        LOGGER.info("SignupPage()");
    }

}
