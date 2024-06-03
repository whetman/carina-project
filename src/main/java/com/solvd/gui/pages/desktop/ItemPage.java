package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.ItemPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ItemPageBase.class)
public class ItemPage extends ItemPageBase {

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void changeQuantity(String quantity) {
        quantityField.click();
        quantityField.type(quantity);
    }

    @Override
    public CartPageBase addToCart() {
        addToCartButton.click();
        continueShopping.click();
        CartPageBase cartPageBase = getHeader().openCartPage();
        return cartPageBase;
    }
}
