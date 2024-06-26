package com.solvd.gui.pages.ios;

import com.solvd.gui.pages.common.PaymentDonePageBase;
import com.solvd.gui.pages.desktop.HomePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = PaymentDonePageBase.class)
public class PaymentDonePage extends PaymentDonePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    public PaymentDonePage(WebDriver driver) {
        super(driver);
        LOGGER.info("PaymentDonePage");
    }

}
