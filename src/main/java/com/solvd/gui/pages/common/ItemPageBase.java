package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class ItemPageBase extends AbstractPageBase{

    @FindBy(id = "quantity")
    protected ExtendedWebElement quantityField;

    @FindBy(xpath = "//span//button")
    protected ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@class, 'modal')]//button")
    protected ExtendedWebElement continueShopping;

    public ItemPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void changeQuantity(String quantity);
    public abstract CartPageBase addToCart();
}
