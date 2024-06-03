package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AccountCreatedPageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountCreatedPageBase.class);

    @FindBy(xpath = "//a[contains(@class, 'btn')]")
    private ExtendedWebElement continueButton;

    public AccountCreatedPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("AccountCreatedPageBase()");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(continueButton);
    }

    public abstract HomePageBase continueAfterAccountCreated();

    public ExtendedWebElement getContinueButton() {
        LOGGER.info("getContinueButton()");
        return continueButton;
    }
}
