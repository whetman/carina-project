package com.solvd.gui.pages.common;

import com.solvd.gui.components.header.HeaderBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePageBase extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderBase getHeader();

    @Override
    public void open() {
        super.open();
    }
}
