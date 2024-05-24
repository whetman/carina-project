package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.PaymentDonePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PaymentDonePageBase.class)
public class PaymentDonePage extends PaymentDonePageBase {

    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }
}
