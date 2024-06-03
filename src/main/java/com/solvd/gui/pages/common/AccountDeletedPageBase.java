package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AccountDeletedPageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDeletedPageBase.class);

    @FindBy(xpath = "//h2[contains(@data-qa, 'deleted')]")
    private ExtendedWebElement accountDeletedMessage;

    @FindBy(xpath = "//a[contains(@data-qa, 'button')]")
    private ExtendedWebElement continueButton;

    public AccountDeletedPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase clickContinueToRedirect();

    public ExtendedWebElement getAccountDeletedMessage() {
        LOGGER.info("getAccountDeletedMessage()");
        return accountDeletedMessage;
    }

    public ExtendedWebElement getContinueButton() {
        LOGGER.info("getContinueButton()");
        return continueButton;
    }
}
