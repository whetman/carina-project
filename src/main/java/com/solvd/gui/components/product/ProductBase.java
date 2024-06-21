package com.solvd.gui.components.product;

import com.solvd.gui.pages.common.ItemPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class ProductBase extends AbstractUIObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBase.class);

    @FindBy(xpath = "//div[@class='product-overlay']//a[contains(@class, 'btn')]")
    private List<ExtendedWebElement> productButton;

    @FindBy(xpath = "//div[@class='features_items']//div[@class='product-image-wrapper']//a[@class=\"btn btn-default add-to-cart\"]")
    private List<ExtendedWebElement> productButtonIOS;

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

    public void clickContinueButton() {
        LOGGER.info("clickContinueButton()");
        getContinueButton().click();
    }

    public void hoverOverProduct(int index) {
        LOGGER.info("hoverOverProduct(" + index + ")");
        scrollTo();
        getProductHoverElement().get(index).hover();
    }

    public String productPriceText() {
        LOGGER.info("productPriceText()");
        return getProductPrice().getText();
    }

    public String productDescriptionText() {
        LOGGER.info("productDescriptionText()");
        return getProductDescription().getText();
    }

    public ItemPageBase clickViewProduct() {
        LOGGER.info("clickViewProduct()");
        getViewProduct().click();
        return initPage(getDriver(), ItemPageBase.class);
    }

    public List<ExtendedWebElement> getProductButton() {
        return productButton;
    }

    public List<ExtendedWebElement> getProductButtonIOS() {
        return productButtonIOS;
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
