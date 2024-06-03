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

    public abstract boolean areAddressesCorrect();

    public abstract PaymentPageBase placeOrder();

    public CheckoutInformation getCheckoutInformation() {
        LOGGER.info("getCheckoutInformation()");
        return checkoutInformation;
    }

    public ExtendedWebElement getPlaceOrderButton() {
        LOGGER.info("getPlaceOrderButton()");
        return placeOrderButton;
    }
}
