package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PaymentDonePageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentDonePageBase.class);

    @FindBy(xpath = "//a[contains(@href, 'invoice')]")
    private ExtendedWebElement invoiceButton;

    public PaymentDonePageBase(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getInvoiceButton() {
        LOGGER.info("getInvoiceButton()");
        return invoiceButton;
    }

}
