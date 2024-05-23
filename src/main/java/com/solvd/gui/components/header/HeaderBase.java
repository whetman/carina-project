package com.solvd.gui.components.header;

import com.solvd.gui.pages.desktop.SignupLoginPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HeaderBase extends AbstractUIObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderBase.class);

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract SignupLoginPage openSignupLoginPage();
}
