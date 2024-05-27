package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.AccountDeletedPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountDeletedPageBase.class)
public class AccountDeletedPage extends AccountDeletedPageBase {

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase clickContinueToRedirect() {
        continueButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
