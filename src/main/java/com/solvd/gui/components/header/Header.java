package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.SignupLoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Header extends HeaderBase{

    private static final Logger LOGGER = LoggerFactory.getLogger(Header.class);

    @FindBy(xpath = "//li//a[@href='/login']")
    private ExtendedWebElement signUpLoginButton;

    @FindBy(xpath = "//li//a[@href='/view_cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//a[contains(@href, 'delete')]")
    private WebElement deleteAccountButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public SignupLoginPageBase openSignupLoginPage() {
        signUpLoginButton.click();
        return initPage(getDriver(), SignupLoginPageBase.class);
    }

    @Override
    public CartPageBase openCartPage() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }
}
