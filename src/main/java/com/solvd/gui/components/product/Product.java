package com.solvd.gui.components.product;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Product extends ProductBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}

