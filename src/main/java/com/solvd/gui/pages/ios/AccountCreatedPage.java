package com.solvd.gui.pages.ios;

import com.solvd.gui.pages.common.AccountCreatedPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AccountCreatedPageBase.class)
public class AccountCreatedPage extends AccountCreatedPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountCreatedPage.class);

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
        LOGGER.info("AccountCreatedPage");
    }

}
