package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.featuresitems.FeaturesItems;
import com.solvd.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsPage.class);

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPageBase typeInSearchBar(String text) {
        searchBar.type(text);
        searchButton.click();
        return initPage(ProductsPageBase.class);
    }

    @Override
    public FeaturesItems getFeaturesItems() {
        LOGGER.info("getFeaturesItems()");
        return getFeaturesItems();
    }

}
