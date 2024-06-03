package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CheckoutPageBase;
import com.solvd.gui.pages.common.PaymentPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutPage.class);

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean areAddressesCorrect() {
        LOGGER.info("areAddressesCorrect()");
        boolean personDetails = getCheckoutInformation().getAddressBilling().getAddressPersonDetails().getText()
                .equals(getCheckoutInformation().getAddressDelivery().getAddressPersonDetails().getText());
        boolean country = getCheckoutInformation().getAddressBilling().getAddressCountry().getText()
                .equals(getCheckoutInformation().getAddressDelivery().getAddressCountry().getText());
        boolean phone = getCheckoutInformation().getAddressBilling().getAddressPhone().getText()
                .equals(getCheckoutInformation().getAddressDelivery().getAddressPhone().getText());
        boolean addressDetails = getCheckoutInformation().getAddressBilling().getAddressDetails().getText()
                .equals(getCheckoutInformation().getAddressDelivery().getAddressDetails().getText());
        boolean street = getCheckoutInformation().getAddressBilling().getAddressStreet().getText()
                .equals(getCheckoutInformation().getAddressDelivery().getAddressStreet().getText());

        return personDetails && country && phone && addressDetails && street;
    }

    @Override
    public PaymentPageBase placeOrder() {
        LOGGER.info("placeOrder()");
        getPlaceOrderButton().scrollTo();
        getPlaceOrderButton().click();
        return initPage(getDriver(), PaymentPageBase.class);
    }

}
