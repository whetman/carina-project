package com.solvd.mobile;

import com.solvd.gui.pages.common.HomePageBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTests extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageTests.class);

    @Test
    public void validateOpenHomePage() {

        SoftAssert sa = new SoftAssert();

        HomePageBase homePage = openHomePage();

        sa.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        sa.assertTrue(homePage.getHeader().isDisplayed(), "Header is not visible");
        sa.assertTrue(homePage.getFeaturesItems().isDisplayed(), "Features items are not displayed");

        sa.assertAll();
    }

}
