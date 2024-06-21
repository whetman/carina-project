package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.ItemPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ItemPageBase.class)
public class ItemPage extends ItemPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemPage.class);

    public ItemPage(WebDriver driver) {
        super(driver);
        LOGGER.info("ItemPage()");
    }

}
