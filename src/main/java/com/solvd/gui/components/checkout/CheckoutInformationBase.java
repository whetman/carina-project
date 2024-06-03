package com.solvd.gui.components.checkout;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationBase extends AbstractUIObject {

    @FindBy(id = "address_delivery")
    private AddressDelivery addressDelivery;

    @FindBy(id = "address_invoice")
    private AddressDelivery addressBilling;

    public CheckoutInformationBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AddressDelivery getAddressDelivery() {
        return addressDelivery;
    }

    public AddressDelivery getAddressBilling() {
        return addressBilling;
    }
}
