package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.AccountCreatedPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountCreatedPageBase.class)
public class AccountCreatedPage extends AccountCreatedPageBase {

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase continueAfterAccountCreated() {
        continueButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }


}
