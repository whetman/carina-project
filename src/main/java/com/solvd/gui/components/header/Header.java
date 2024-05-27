package com.solvd.gui.components.header;

import com.solvd.gui.pages.common.AccountDeletedPageBase;
import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.SignupLoginPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Header extends HeaderBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(Header.class);

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

    @Override
    public AccountDeletedPageBase deleteAccount() {
        deleteAccountButton.click();
        return initPage(AccountDeletedPageBase.class);
    }
}
