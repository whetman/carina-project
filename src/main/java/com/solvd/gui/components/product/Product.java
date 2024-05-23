package com.solvd.gui.components.product;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Product extends ProductBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

    @FindBy(xpath = "//div[@class='product-overlay']//a[contains(@class, 'btn')]")
    private List<ExtendedWebElement> productButton;

    @FindBy(xpath = "//div[contains(@class, 'features_items')]//div[@class='single-products']")
    private List<ExtendedWebElement> productHoverElement;

    @FindBy(xpath = "//button[contains(text(), 'Continue')]")
    private ExtendedWebElement continueButton;

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void clickContinueButton() {
        continueButton.click();
    }

    @Override
    public void clickAddToCartButton(int index) {
        productButton.get(index).click();
    }

    @Override
    public void hoverOverProduct(int index) {
        scrollTo();
        productHoverElement.get(index).hover();
    }

    public List<ExtendedWebElement> getProductButton() {
        return productButton;
    }

    public List<ExtendedWebElement> getProductHoverElement() {
        return productHoverElement;
    }
}

