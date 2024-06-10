package com.solvd.gui.pages.mobile;

import com.solvd.gui.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutPage.class);

    public CheckoutPage(WebDriver driver) {
        super(driver);
        LOGGER.info("CheckoutPage()");
    }

}
