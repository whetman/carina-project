package com.solvd.gui.pages.mobile;

import com.solvd.gui.pages.common.PaymentDonePageBase;
import com.solvd.gui.pages.common.PaymentPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PaymentPageBase.class)
public class PaymentPage extends PaymentPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentPage.class);

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PaymentDonePageBase enterPaymentDetailsAndContinue(String nameOnCard, String cardNumber, String cvc, String expirationMonth, String expirationYear) {
        LOGGER.info("enterPaymentDetailsAndContinue()");
        nameOnCardField.type(nameOnCard);
        cardNumberField.type(cardNumber);
        cvcField.type(cvc);
        expirationMonthField.type(expirationMonth);
        expirationYearField.type(expirationYear);
        submitButton.click();
        return initPage(getDriver(), PaymentDonePageBase.class);
    }

}
