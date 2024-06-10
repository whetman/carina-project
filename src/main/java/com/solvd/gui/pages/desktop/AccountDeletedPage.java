package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.AccountDeletedPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountDeletedPageBase.class)
public class AccountDeletedPage extends AccountDeletedPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDeletedPage.class);

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
        LOGGER.info("AccountDeletedPage()");
    }

}
