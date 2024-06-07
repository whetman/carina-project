package com.solvd.gui.pages.mobile;

import com.solvd.gui.pages.common.AccountDeletedPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccountDeletedPageBase.class)
public class AccountDeletedPage extends AccountDeletedPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDeletedPage.class);

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase clickContinueToRedirect() {
        LOGGER.info("clickContinueToRedirect()");
        getContinueButton().click();
        return initPage(getDriver(), HomePageBase.class);
    }

}
