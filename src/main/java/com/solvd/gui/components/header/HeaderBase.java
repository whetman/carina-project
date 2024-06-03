package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.AccountDeletedPageBase;
import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.ProductsPageBase;
import com.solvd.gui.pages.common.SignupLoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HeaderBase extends AbstractUIObject {

    @FindBy(xpath = ".//a[@href='/login']")
    private ExtendedWebElement signUpLoginButton;

    @FindBy(xpath = ".//a[@href='/view_cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = ".//a[contains(@href, 'delete')]")
    private ExtendedWebElement deleteAccountButton;

    @FindBy(xpath = ".//a[contains(@href, '/products')]")
    private ExtendedWebElement productsPage;

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract SignupLoginPageBase openSignupLoginPage();

    public abstract CartPageBase openCartPage();

    public abstract AccountDeletedPageBase deleteAccount();

    public abstract ProductsPageBase openProductsPage();

    public ExtendedWebElement getSignUpLoginButton() {
        return signUpLoginButton;
    }

    public ExtendedWebElement getCartButton() {
        return cartButton;
    }

    public ExtendedWebElement getDeleteAccountButton() {
        return deleteAccountButton;
    }

    public ExtendedWebElement getProductsPage() {
        return productsPage;
    }
}
