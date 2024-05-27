package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AccountCreatedPageBase extends AbstractPage {

    @FindBy(xpath = "//a[contains(@class, 'btn')]")
    protected ExtendedWebElement continueButton;

    public AccountCreatedPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase continueAfterAccountCreated();
}
