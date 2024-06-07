package com.solvd.tests;

import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;

public abstract class AbstractTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    private WebDriver driver;

    public HomePageBase openHomePage() {
        LOGGER.info("Opening HomePage");

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        return homePage;
    }

//    @BeforeClass
//    @Parameters({"browser"})
//    public void setUp(String browser) {
//        R.CONFIG.put("capabilities.browserName", browser);
//    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
