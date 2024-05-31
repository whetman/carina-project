package com.solvd.gui.components.product;

import com.solvd.gui.pages.common.ItemPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Product extends ProductBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

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

    @Override
    public String getProductPrice() {
        return productPrice.getText();
    }

    @Override
    public String getProductDescription() {
        return productDescription.getText();
    }

    @Override
    public ItemPageBase clickViewProduct() {
        viewProduct.click();
        return initPage(getDriver(), ItemPageBase.class);
    }

    public List<ExtendedWebElement> getProductButton() {
        return productButton;
    }

    public List<ExtendedWebElement> getProductHoverElement() {
        return productHoverElement;
    }

}

