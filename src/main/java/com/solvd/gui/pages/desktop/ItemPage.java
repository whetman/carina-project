package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.ItemPageBase;
import com.solvd.gui.pages.common.SignupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ItemPageBase.class)
public class ItemPage extends ItemPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemPage.class);

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void changeQuantity(String quantity) {
        LOGGER.info("changeQuantity(" + quantity + ")");
        getQuantityField().click();
        getQuantityField().type(quantity);
    }

    @Override
    public CartPageBase addToCart() {
        LOGGER.info("addToCart()");
        getAddToCartButton().click();
        getContinueShopping().click();
        CartPageBase cartPageBase = getHeader().openCartPage();
        return cartPageBase;
    }
}
