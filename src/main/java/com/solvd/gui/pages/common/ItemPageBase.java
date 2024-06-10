package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ItemPageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemPageBase.class);

    @FindBy(id = "quantity")
    private ExtendedWebElement quantityField;

    @FindBy(xpath = "//span//button")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@class, 'modal')]//button")
    private ExtendedWebElement continueShopping;

    public ItemPageBase(WebDriver driver) {
        super(driver);
    }

    public void changeQuantity(String quantity) {
        LOGGER.info("changeQuantity(" + quantity + ")");
        getQuantityField().click();
        getQuantityField().type(quantity);
    }

    public CartPageBase addToCart() {
        LOGGER.info("addToCart()");
        getAddToCartButton().click();
        getContinueShopping().click();
        CartPageBase cartPageBase = getHeader().openCartPage();
        return cartPageBase;
    }

    public ExtendedWebElement getQuantityField() {
        LOGGER.info("getQuantityField()");
        return quantityField;
    }

    public ExtendedWebElement getAddToCartButton() {
        LOGGER.info("getAddToCartButton()");
        return addToCartButton;
    }

    public ExtendedWebElement getContinueShopping() {
        LOGGER.info("getContinueShopping()");
        return continueShopping;
    }
}
