package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.AccountDeletedPageBase;
import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.ProductsPageBase;
import com.solvd.gui.pages.common.SignupLoginPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Header extends HeaderBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(Header.class);

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public SignupLoginPageBase openSignupLoginPage() {
        LOGGER.info("openSignupLoginPage()");
        getSignUpLoginButton().click();
        return initPage(getDriver(), SignupLoginPageBase.class);
    }

    @Override
    public CartPageBase openCartPage() {
        LOGGER.info("openCartPage()");
//        ExpectedConditions
        waitUntil(visibilityOf(getCartButton()), Duration.ofSeconds(30L));
        getCartButton().click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public AccountDeletedPageBase deleteAccount() {
        LOGGER.info("deleteAccount()");
        getDeleteAccountButton().click();
        return initPage(AccountDeletedPageBase.class);
    }

    @Override
    public ProductsPageBase openProductsPage() {
        LOGGER.info("openProductsPage()");
        getProductsPage().click();
        return initPage(ProductsPageBase.class);
    }

}
