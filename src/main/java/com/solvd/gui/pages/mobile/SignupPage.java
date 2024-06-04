package com.solvd.gui.pages.mobile;

import com.solvd.gui.constants.Gender;
import com.solvd.gui.models.AccountInformation;
import com.solvd.gui.pages.common.AccountCreatedPageBase;
import com.solvd.gui.pages.common.SignupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignupPageBase.class)
public class SignupPage extends SignupPageBase implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupPage.class);

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountCreatedPageBase enterAccountInformation(AccountInformation accountInformation) {

        LOGGER.info("enterAccountInformation()");

        if (accountInformation.getGender().equals(Gender.MRS)) {
            getTitleMrs().click();
        } else {
            getTitleMr().click();
        }

        getPasswordBox().type(accountInformation.getPassword());

        getDaysDropdown().click();
        getDaysDropdown().select(accountInformation.getDayOfBirth());

        getMonthsDropdown().click();
        getMonthsDropdown().select(accountInformation.getMonthOfBirth());

        getYearsDropdown().click();
        getYearsDropdown().select(accountInformation.getYearOfBirth());

        getFirstNameBox().type(accountInformation.getSignupName());
        getLastnameNameBox().type(accountInformation.getLastName());
        getAddressBox().type(accountInformation.getAddress());

        getCountryDropdown().scrollTo();

        getCountryDropdown().click();
        getCountryDropdown().select(accountInformation.getCountry());

        getStateBox().type(accountInformation.getState());
        getCityBox().type(accountInformation.getCity());
        getZipcodeBox().type(accountInformation.getZipcode());
        getMobileNumberBox().type(accountInformation.getMobileNumber());
        getCreateAccountButton().click();
        getCreateAccountButton().click();

        return initPage(getDriver(), AccountCreatedPageBase.class);
    }

    @Override
    public ExtendedWebElement getEmailAlreadyExistsMessage() {
        LOGGER.info("getEmailAlreadyExistsMessage()");
        return emailAlreadyExistsMessage;
    }
}
