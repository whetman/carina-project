package com.solvd.gui.pages.common;

import com.solvd.gui.components.checkout.CheckoutInformation;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class CheckoutPageBase extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'checkout')]")
    protected CheckoutInformation checkoutInformation;

    @FindBy(xpath = "//a[contains(@class, 'btn')]")
    protected ExtendedWebElement placeOrderButton;

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean areAddressesCorrect();

    public abstract PaymentPageBase placeOrder();
}
