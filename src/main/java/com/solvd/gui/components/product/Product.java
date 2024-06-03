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
        LOGGER.info("clickContinueButton()");
        getContinueButton().click();
    }

    @Override
    public void clickAddToCartButton(int index) {
        LOGGER.info("clickAddToCartButton(" + index + ")");
        getProductButton().get(index).click();
    }

    @Override
    public void hoverOverProduct(int index) {
        LOGGER.info("hoverOverProduct(" + index + ")");
        scrollTo();
        getProductHoverElement().get(index).hover();
    }

    @Override
    public String productPriceText() {
        LOGGER.info("productPriceText()");
        return getProductPrice().getText();
    }

    @Override
    public String productDescriptionText() {
        LOGGER.info("productDescriptionText()");
        return getProductDescription().getText();
    }

    @Override
    public ItemPageBase clickViewProduct() {
        LOGGER.info("clickViewProduct()");
        getViewProduct().click();
        return initPage(getDriver(), ItemPageBase.class);
    }

}

