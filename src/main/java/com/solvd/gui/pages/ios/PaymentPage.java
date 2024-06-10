package com.solvd.gui.pages.ios;

import com.solvd.gui.pages.common.PaymentPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PaymentPageBase.class)
public class PaymentPage extends PaymentPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentPage.class);

    public PaymentPage(WebDriver driver) {
        super(driver);
        LOGGER.info("PaymentPage()");
    }

}
