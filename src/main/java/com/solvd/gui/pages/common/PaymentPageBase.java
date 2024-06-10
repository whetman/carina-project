package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PaymentPageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentPageBase.class);

    @FindBy(xpath = "//input[@name='name_on_card']")
    private ExtendedWebElement nameOnCardField;

    @FindBy(xpath = "//input[@name='card_number']")
    private ExtendedWebElement cardNumberField;

    @FindBy(xpath = "//input[@name='cvc']")
    private ExtendedWebElement cvcField;

    @FindBy(xpath = "//input[@name='expiry_month']")
    private ExtendedWebElement expirationMonthField;

    @FindBy(xpath = "//input[@name='expiry_year']")
    private ExtendedWebElement expirationYearField;

    @FindBy(id = "submit")
    private ExtendedWebElement submitButton;

    public PaymentPageBase(WebDriver driver) {
        super(driver);
    }

    public PaymentDonePageBase enterPaymentDetailsAndContinue(String nameOnCard, String cardNumber, String cvc, String expirationMonth, String expirationYear) {
        LOGGER.info("enterPaymentDetailsAndContinue()");
        getNameOnCardField().type(nameOnCard);
        getCardNumberField().type(cardNumber);
        getCvcField().type(cvc);
        getExpirationMonthField().type(expirationMonth);
        getExpirationYearField().type(expirationYear);
        getSubmitButton().click();
        return initPage(getDriver(), PaymentDonePageBase.class);
    }
    public ExtendedWebElement getNameOnCardField() {
        LOGGER.info("getNameOnCardField()");
        return nameOnCardField;
    }

    public ExtendedWebElement getCardNumberField() {
        LOGGER.info("getCardNumberField()");
        return cardNumberField;
    }

    public ExtendedWebElement getCvcField() {
        LOGGER.info("getCvcField()");
        return cvcField;
    }

    public ExtendedWebElement getExpirationMonthField() {
        LOGGER.info("getExpirationMonthField()");
        return expirationMonthField;
    }

    public ExtendedWebElement getExpirationYearField() {
        LOGGER.info("getExpirationYearField()");
        return expirationYearField;
    }

    public ExtendedWebElement getSubmitButton() {
        LOGGER.info("");
        return submitButton;
    }
}
