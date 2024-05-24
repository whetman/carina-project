package com.solvd.web;

import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    public HomePageBase openHomePage() {
        LOGGER.info("Opening HomePage");

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        return homePage;
    }

}
