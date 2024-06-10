package com.solvd.gui.pages.common;

import com.solvd.gui.components.checkout.CheckoutInformation;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CheckoutPageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutPageBase.class);

    @FindBy(xpath = "//div[contains(@class, 'checkout')]")
    private CheckoutInformation checkoutInformation;

    @FindBy(xpath = "//a[contains(@class, 'btn')]")
    private ExtendedWebElement placeOrderButton;

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

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

    public PaymentPageBase placeOrder() {
        LOGGER.info("placeOrder()");
        getPlaceOrderButton().scrollTo();
        getPlaceOrderButton().click();
        return initPage(getDriver(), PaymentPageBase.class);
    }

    public CheckoutInformation getCheckoutInformation() {
        LOGGER.info("getCheckoutInformation()");
        return checkoutInformation;
    }

    public ExtendedWebElement getPlaceOrderButton() {
        LOGGER.info("getPlaceOrderButton()");
        return placeOrderButton;
    }
}
