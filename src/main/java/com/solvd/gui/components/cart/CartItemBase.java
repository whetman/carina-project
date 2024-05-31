package com.solvd.gui.components.cart;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class CartItemBase extends AbstractUIObject {

    @FindBy(xpath = ".//td[contains(@class, 'description')]")
    protected ExtendedWebElement cartItemDescription;

    @FindBy(xpath = ".//td[contains(@class, 'price')]")
    protected ExtendedWebElement cartItemPrice;

    @FindBy(xpath = ".//td[contains(@class, 'quantity')]")
    protected ExtendedWebElement cartItemQuantity;

    @FindBy(xpath = ".//td[contains(@class, 'total')]")
    protected ExtendedWebElement cartItemTotal;

    @FindBy(xpath = ".//td[contains(@class, 'delete')]")
    protected ExtendedWebElement cartItemDeleteButton;

    public CartItemBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getCartItemsDescriptions() {
        return cartItemDescription.getText();
    }

    public String getCartItemsPrices() {
        return cartItemPrice.getText();
    }

    public String getCartItemsQuantities() {
        return cartItemQuantity.getText();
    }

    public String getCartItemsTotals() {
        return cartItemTotal.getText();
    }

    public ExtendedWebElement getCartItemsDeleteButtons() {
        return cartItemDeleteButton;
    }

    public ExtendedWebElement getCartItemDescription() {
        return cartItemDescription;
    }

    public ExtendedWebElement getCartItemPrice() {
        return cartItemPrice;
    }

    public ExtendedWebElement getCartItemQuantity() {
        return cartItemQuantity;
    }

    public ExtendedWebElement getCartItemTotal() {
        return cartItemTotal;
    }

    public ExtendedWebElement getCartItemDeleteButton() {
        return cartItemDeleteButton;
    }
}
