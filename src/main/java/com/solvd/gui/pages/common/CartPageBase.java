package com.solvd.gui.pages.common;

import com.solvd.gui.components.cart.Cart;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class CartPageBase extends AbstractPage {

    @FindBy(id = "cart_items")
    protected Cart cart;

    @FindBy(xpath = "//a[contains(@class, 'check_out')]")
    protected ExtendedWebElement checkoutButton;

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void buyProducts();

    public abstract String getCartItemDescription(int index);
    public abstract void getCartItemsPrices();
    public abstract void getCartItemsQuantities();

}
