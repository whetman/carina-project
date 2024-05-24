package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.cart.CartItem;
import com.solvd.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    public CartPage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.automationexercise.com/view_cart");
    }

    @Override
    public void buyProducts() {
        checkoutButton.click();
    }

    @Override
    public String getCartItemDescription(int index) {
        List<CartItem> cartItems = cart.getCartItems();
        String description = cartItems.get(index).getCartItemsDescriptions();
        return description;
    }

    @Override
    public void getCartItemsPrices() {

    }

    @Override
    public void getCartItemsQuantities() {

    }

}
