package com.solvd.gui.pages.common;

import com.solvd.gui.components.cart.Cart;
import com.solvd.gui.components.cart.CartItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class CartPageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartPageBase.class);

    @FindBy(id = "cart_items")
    private Cart cart;

    @FindBy(xpath = "//a[contains(@class, 'check_out')]")
    private ExtendedWebElement checkoutButton;

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public CheckoutPageBase buyProducts() {
        LOGGER.info("buyProducts()");
        getCheckoutButton().click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }

    public String getCartItemDescription(int index) {
        LOGGER.info("getCartItemDescription(" + index + ")");
        List<CartItem> cartItems = getCart().getCartItems();
        String description = cartItems.get(index).getCartItemDescription().getText();
        return description;
    }

    public String getCartItemQuantity(int index) {
        LOGGER.info("getCartItemQuantity(" + index + ")");
        List<CartItem> cartItems = getCart().getCartItems();
        String cartItemsQuantities = cartItems.get(index).getCartItemQuantity().getText();
        return cartItemsQuantities;
    }

    public Cart getCart() {
        LOGGER.info("getCart()");
        return cart;
    }

    public ExtendedWebElement getCheckoutButton() {
        LOGGER.info("getCheckoutButton()");
        return checkoutButton;
    }
}
