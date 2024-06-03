package com.solvd.gui.pages.common;

import com.solvd.gui.components.cart.Cart;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CartPageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartPageBase.class);

    @FindBy(id = "cart_items")
    private Cart cart;

    @FindBy(xpath = "//a[contains(@class, 'check_out')]")
    private ExtendedWebElement checkoutButton;

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CheckoutPageBase buyProducts();

    public abstract String getCartItemDescription(int index);
    public abstract String getCartItemQuantity(int index);

    public Cart getCart() {
        LOGGER.info("getCart()");
        return cart;
    }

    public ExtendedWebElement getCheckoutButton() {
        LOGGER.info("getCheckoutButton()");
        return checkoutButton;
    }
}
