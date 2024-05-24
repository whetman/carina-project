package com.solvd.gui.components.product;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class ProductBase extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='product-overlay']//a[contains(@class, 'btn')]")
    protected List<ExtendedWebElement> productButton;

    @FindBy(xpath = "//div[contains(@class, 'features_items')]//div[@class='single-products']")
    protected List<ExtendedWebElement> productHoverElement;

    @FindBy(xpath = "//button[contains(text(), 'Continue')]")
    protected ExtendedWebElement continueButton;

    @FindBy(xpath = ".//div[@class='single-products']//div[contains(@class, 'productinfo')]//h2")
    protected ExtendedWebElement productPrice;

    @FindBy(xpath = ".//div[@class='single-products']//div[contains(@class, 'productinfo')]//p")
    protected ExtendedWebElement productDescription;

    public ProductBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void clickContinueButton();

    public abstract void clickAddToCartButton(int index);

    public abstract void hoverOverProduct(int index);

    public abstract String getProductPrice();

    public abstract String getProductDescription();

}
