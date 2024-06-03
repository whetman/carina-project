package com.solvd.gui.components.featuresitems;

import com.solvd.gui.components.product.Product;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class FeaturesItemsBase extends AbstractUIObject {

    @FindBy(xpath = ".//div[@class='product-image-wrapper']")
    private List<Product> products;

    public FeaturesItemsBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<Product> getProducts() {
        return products;
    }
}
