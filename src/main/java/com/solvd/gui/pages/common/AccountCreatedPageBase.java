package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AccountCreatedPageBase extends AbstractPageBase {

    @FindBy(xpath = "//a[contains(@class, 'btn')]")
    protected ExtendedWebElement continueButton;

    public AccountCreatedPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(continueButton);
    }

    public abstract HomePageBase continueAfterAccountCreated();

}
