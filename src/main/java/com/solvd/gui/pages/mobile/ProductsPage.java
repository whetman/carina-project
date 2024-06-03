package com.solvd.gui.pages.mobile;

import com.solvd.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsPage.class);

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPageBase typeInSearchBar(String text) {
        LOGGER.info("typeInSearchBar(" + text + ")");
        getSearchBar().type(text);
        getSearchButton().click();
        return initPage(ProductsPageBase.class);
    }

}
