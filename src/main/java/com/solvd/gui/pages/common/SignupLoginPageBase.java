package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SignupLoginPageBase extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupLoginPageBase.class);

    public SignupLoginPageBase(WebDriver driver) {
        super(driver);
    }
}
