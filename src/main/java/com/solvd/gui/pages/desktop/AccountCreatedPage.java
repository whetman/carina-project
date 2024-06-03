package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.AccountCreatedPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountCreatedPageBase.class)
public class AccountCreatedPage extends AccountCreatedPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountCreatedPage.class);

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase continueAfterAccountCreated() {
        LOGGER.info("continueAfterAccountCreated()");
        getContinueButton().click();
        return initPage(getDriver(), HomePageBase.class);
    }

}
