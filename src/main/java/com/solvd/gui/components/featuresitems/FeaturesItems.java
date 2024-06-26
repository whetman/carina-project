package com.solvd.gui.components.featuresitems;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.product.Product;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FeaturesItems extends FeaturesItemsBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(Header.class);

    public FeaturesItems(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
