package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class PaymentDonePageBase extends AbstractPage {

    @FindBy(xpath = "//a[contains(@href, 'invoice')]")
    protected ExtendedWebElement invoiceButton;

    public PaymentDonePageBase(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getInvoiceButton() {
        return invoiceButton;
    }
}
