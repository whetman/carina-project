package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.PaymentDonePageBase;
import com.solvd.gui.pages.common.PaymentPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PaymentPageBase.class)
public class PaymentPage extends PaymentPageBase {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PaymentDonePageBase enterPaymentDetailsAndContinue(String nameOnCard, String cardNumber, String cvc, String expirationMonth, String expirationYear) {
        nameOnCardField.type(nameOnCard);
        cardNumberField.type(cardNumber);
        cvcField.type(cvc);
        expirationMonthField.type(expirationMonth);
        expirationYearField.type(expirationYear);
        submitButton.click();
        return initPage(getDriver(), PaymentDonePageBase.class);
    }

}
