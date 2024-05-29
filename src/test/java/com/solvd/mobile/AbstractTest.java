package com.solvd.mobile;

import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class AbstractTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    private WebDriver driver;

    public HomePageBase openHomePage() {
        LOGGER.info("Opening HomePage");

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        return homePage;
    }

    @BeforeTest
    @Override
    public WebDriver getDriver() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "ANDROID");
        dc.setCapability("appium:automationName", "UiAutomator2");
        dc.setCapability("appium:deviceName", "Pixel_3a");
        dc.setCapability("appium:deviceType", "phone");
        dc.setCapability("appium:udid", "emulator-5556");
        dc.setCapability("browserName", "chrome");
        dc.setCapability("chromedriverExecutable", "C:\\Users\\wikhe\\selenium\\chromedriver.exe");
        return getDriver("default", dc, "http://192.168.1.113:4723/");
    }

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        R.CONFIG.put("capabilities.browserName", browser);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}