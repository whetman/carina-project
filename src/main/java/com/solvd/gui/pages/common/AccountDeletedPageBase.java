package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AccountDeletedPageBase extends AbstractPage {

    @FindBy(xpath = "//h2[contains(@data-qa, 'deleted')]")
    protected ExtendedWebElement accountDeletedMessage;

    @FindBy(xpath = "//a[contains(@data-qa, 'button')]")
    protected ExtendedWebElement continueButton;

    public AccountDeletedPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase clickContinueToRedirect();

}
