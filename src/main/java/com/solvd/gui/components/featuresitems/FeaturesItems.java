package com.solvd.gui.components.featuresitems;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.product.Product;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FeaturesItems extends FeaturesItemsBase{

    private static final Logger LOGGER = LoggerFactory.getLogger(Header.class);

    @FindBy(xpath = "//div[@class='features_items']//div[@class='product-image-wrapper']")
    private List<Product> products;

    public FeaturesItems(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<Product> getProducts() {
        LOGGER.info("getProducts()");
        return products;
    }

}
