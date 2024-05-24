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
        boolean personDetails = checkoutInformation.getAddressBilling().getAddressPersonDetails().getText()
                .equals(checkoutInformation.getAddressDelivery().getAddressPersonDetails().getText());
        boolean country = checkoutInformation.getAddressBilling().getAddressCountry().getText()
                .equals(checkoutInformation.getAddressDelivery().getAddressCountry().getText());
        boolean phone = checkoutInformation.getAddressBilling().getAddressPhone().getText()
                .equals(checkoutInformation.getAddressDelivery().getAddressPhone().getText());
        boolean addressDetails = checkoutInformation.getAddressBilling().getAddressDetails().getText()
                .equals(checkoutInformation.getAddressDelivery().getAddressDetails().getText());
        boolean street = checkoutInformation.getAddressBilling().getAddressStreet().getText()
                .equals(checkoutInformation.getAddressDelivery().getAddressStreet().getText());

        return personDetails && country && phone && addressDetails && street;
    }

    @Override
    public PaymentPageBase placeOrder() {
        placeOrderButton.scrollTo();
        placeOrderButton.click();
        return initPage(getDriver(), PaymentPageBase.class);
    }
}
