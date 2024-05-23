package com.solvd.gui.components.featuresitems;

import com.solvd.gui.components.product.Product;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class FeaturesItemsBase extends AbstractUIObject {

    public FeaturesItemsBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract List<Product> getProducts();

}