package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
        LOGGER.info("CartPage()");
        setPageURL("https://www.automationexercise.com/view_cart");
    }

}
