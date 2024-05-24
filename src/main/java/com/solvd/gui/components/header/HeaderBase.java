package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.SignupLoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class HeaderBase extends AbstractUIObject {

    @FindBy(xpath = ".//a[@href='/login']")
    protected ExtendedWebElement signUpLoginButton;

    @FindBy(xpath = ".//a[@href='/view_cart']")
    protected ExtendedWebElement cartButton;

    @FindBy(xpath = ".//a[contains(@href, 'delete')]")
    protected WebElement deleteAccountButton;

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract SignupLoginPageBase openSignupLoginPage();

    public abstract CartPageBase openCartPage();
}
