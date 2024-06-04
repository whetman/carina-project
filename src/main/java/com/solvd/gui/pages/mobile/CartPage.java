package com.solvd.gui.pages.mobile;

import com.solvd.gui.components.cart.CartItem;
import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.automationexercise.com/view_cart");
    }

    @Override
    public CheckoutPageBase buyProducts() {
        LOGGER.info("buyProducts()");
        getCheckoutButton().click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }

    @Override
    public String getCartItemDescription(int index) {
        LOGGER.info("getCartItemDescription(" + index + ")");
        List<CartItem> cartItems = getCart().getCartItems();
        String description = cartItems.get(index).getCartItemDescription().getText();
        return description;
    }

    @Override
    public String getCartItemQuantity(int index) {
        LOGGER.info("getCartItemQuantity(" + index + ")");
        List<CartItem> cartItems = getCart().getCartItems();
        String cartItemsQuantities = cartItems.get(index).getCartItemQuantity().getText();
        return cartItemsQuantities;
    }

}
