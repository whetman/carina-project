package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AccountDeletedPageBase extends AbstractPageBase {

    @FindBy(xpath = "//h2[contains(@data-qa, 'deleted')]")
    protected ExtendedWebElement accountDeletedMessage;

    @FindBy(xpath = "//a[contains(@data-qa, 'button')]")
    protected ExtendedWebElement continueButton;

    public AccountDeletedPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase clickContinueToRedirect();

    public ExtendedWebElement getAccountDeletedMessage() {
        return accountDeletedMessage;
    }
}
