package com.solvd.gui.pages.common;

import com.solvd.gui.components.featuresitems.FeaturesItems;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class ProductsPageBase extends AbstractPageBase {

    @FindBy(id = "search_product")
    protected ExtendedWebElement searchBar;

    @FindBy(id = "submit_search")
    protected ExtendedWebElement searchButton;

    public ProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductsPageBase typeInSearchBar(String text);
    public abstract FeaturesItems getFeaturesItems();


}
