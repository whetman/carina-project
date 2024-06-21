package com.solvd.tests;

import com.solvd.gui.models.PaymentInformation;
import com.solvd.gui.pages.common.*;
import com.solvd.gui.util.MobileContextUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SwitchContextTests extends AbstractTest{

    @DataProvider(name = "accountData")
    public Object[][] loginData() {
        return new Object[][]{
                //{"tadeusz@email.com", "password1", new PaymentInformation("Tadeusz Kowalski", "999999666666", "000", "12", "2300")},
                //{"jolanta@email.com", "password2", new PaymentInformation("Jolanta Kowalska", "111222333444", "001", "11", "2036")},
                {"wiktoria999@email.com", "password1", new PaymentInformation("Wik wik", "777888999555", "002", "10", "2080")},
        };
    }

    @Test(testName = "#TC0005", description = "Verify if logged user can download invoice after finishing shopping", dataProvider = "accountData", priority = 1)
    public void validateDownloadingInvoice(String email, String password, PaymentInformation paymentInformation){

        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();

//        if(homePage.getGoogleDataAgreementButton().isVisible()){
//            homePage.clickGoogleDataAgreementButton();
//        }

        HomePageBase loggedHomePage = homePage.login(email, password);

        loggedHomePage.addRandomProductToCart();

        CartPageBase cartPage = loggedHomePage.goToCart();

        CheckoutPageBase checkoutPage = cartPage.buyProducts();

        PaymentPageBase paymentPage = checkoutPage.placeOrder();

        PaymentDonePageBase paymentDonePage = paymentPage.enterPaymentDetailsAndContinue(paymentInformation.getNameOnCard(), paymentInformation.getCardNumber(), paymentInformation.getCvcNumber(), paymentInformation.getExpirationMonth(), paymentInformation.getExpirationYear());

        paymentDonePage.getInvoiceButton().click();

        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);

        paymentDonePage.getChromeMenuButton().click();
        paymentDonePage.getChromeDownloads().click();

        boolean visible = paymentDonePage.getInvoice().isVisible();

        softAssert.assertTrue(visible, "Invoice is not visibile");
        softAssert.assertAll();


    }


}
