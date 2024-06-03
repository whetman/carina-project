package com.solvd.gui.components.product;

import com.solvd.gui.pages.common.ItemPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class ProductBase extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='product-overlay']//a[contains(@class, 'btn')]")
    private List<ExtendedWebElement> productButton;

    @FindBy(xpath = "//div[contains(@class, 'features_items')]//div[@class='single-products']")
    private List<ExtendedWebElement> productHoverElement;

    @FindBy(xpath = "//button[contains(text(), 'Continue')]")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = ".//div[@class='single-products']//div[contains(@class, 'productinfo')]//h2")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//div[@class='single-products']//div[contains(@class, 'productinfo')]//p")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = ".//a[contains(text(), 'View Product')]")
    private ExtendedWebElement viewProduct;

    public ProductBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void clickContinueButton();

    public abstract void clickAddToCartButton(int index);

    public abstract void hoverOverProduct(int index);

    public abstract ItemPageBase clickViewProduct();

    public abstract String productDescriptionText();

    public abstract String productPriceText();

    public List<ExtendedWebElement> getProductButton() {
        return productButton;
    }

    public List<ExtendedWebElement> getProductHoverElement() {
        return productHoverElement;
    }

    public ExtendedWebElement getContinueButton() {
        return continueButton;
    }

    public ExtendedWebElement getProductPrice() {
        return productPrice;
    }

    public ExtendedWebElement getProductDescription() {
        return productDescription;
    }

    public ExtendedWebElement getViewProduct() {
        return viewProduct;
    }
}
