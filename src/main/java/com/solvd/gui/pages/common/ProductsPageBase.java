package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ProductsPageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsPageBase.class);

    @FindBy(id = "search_product")
    private ExtendedWebElement searchBar;

    @FindBy(id = "submit_search")
    private ExtendedWebElement searchButton;

    public ProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public ProductsPageBase typeInSearchBar(String text) {
        LOGGER.info("typeInSearchBar(" + text + ")");
        getSearchBar().type(text);
        getSearchButton().click();
        return initPage(ProductsPageBase.class);
    }

    public ExtendedWebElement getSearchBar() {
        LOGGER.info("getSearchBar()");
        return searchBar;
    }

    public ExtendedWebElement getSearchButton() {
        LOGGER.info("getSearchButton()");
        return searchButton;
    }
}
