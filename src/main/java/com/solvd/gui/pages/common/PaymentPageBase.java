package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class PaymentPageBase extends AbstractPage {

    @FindBy(xpath = "//input[@name='name_on_card']")
    protected ExtendedWebElement nameOnCardField;

    @FindBy(xpath = "//input[@name='card_number']")
    protected ExtendedWebElement cardNumberField;

    @FindBy(xpath = "//input[@name='cvc']")
    protected ExtendedWebElement cvcField;

    @FindBy(xpath = "//input[@name='expiry_month']")
    protected ExtendedWebElement expirationMonthField;

    @FindBy(xpath = "//input[@name='expiry_year']")
    protected ExtendedWebElement expirationYearField;

    @FindBy(id = "submit")
    protected ExtendedWebElement submitButton;

    public PaymentPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract PaymentDonePageBase enterPaymentDetailsAndContinue(String nameOnCard, String cardNumber, String cvc, String expirationMonth, String expirationYear);

}
