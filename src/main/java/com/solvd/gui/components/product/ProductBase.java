package com.solvd.gui.components.product;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductBase extends AbstractUIObject {

    public ProductBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void clickContinueButton();
    public abstract void clickAddToCartButton(int index);
    public abstract void hoverOverProduct(int index);

}
