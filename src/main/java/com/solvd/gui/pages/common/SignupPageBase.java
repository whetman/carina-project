package com.solvd.gui.pages.common;

import com.solvd.gui.models.AccountInformation;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignupPageBase extends AbstractPage {
    public SignupPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterAccountInformation(AccountInformation accountInformation);
}
