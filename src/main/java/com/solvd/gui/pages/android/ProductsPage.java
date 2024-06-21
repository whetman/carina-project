package com.solvd.gui.pages.android;

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
        LOGGER.info("ProductsPage()");
    }

}
