package com.solvd.gui.components.cart;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class CartBase extends AbstractUIObject {

    @FindBy(xpath = ".//tbody/tr")
    private List<CartItem> cartItems;

    public CartBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

}
