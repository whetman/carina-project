package com.solvd.gui.pages.desktop;

import com.solvd.gui.constants.Gender;
import com.solvd.gui.models.AccountInformation;
import com.solvd.gui.pages.common.AccountCreatedPageBase;
import com.solvd.gui.pages.common.SignupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignupPageBase.class)
public class SignupPage extends SignupPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupPage.class);

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountCreatedPageBase enterAccountInformation(AccountInformation accountInformation) {

        LOGGER.info("enterAccountInformation()");

        if (accountInformation.getGender().equals(Gender.MRS)) {
            titleMrs.click();
        } else {
            titleMr.click();
        }

        passwordBox.type(accountInformation.getPassword());

        daysDropdown.click();
        daysDropdown.select(accountInformation.getDayOfBirth());

        monthsDropdown.click();
        monthsDropdown.select(accountInformation.getMonthOfBirth());

        yearsDropdown.click();
        yearsDropdown.select(accountInformation.getYearOfBirth());

        firstNameBox.type(accountInformation.getSignupName());
        lastnameNameBox.type(accountInformation.getLastName());
        addressBox.type(accountInformation.getAddress());

        countryDropdown.scrollTo();

        countryDropdown.click();
        countryDropdown.select(accountInformation.getCountry());

        stateBox.type(accountInformation.getState());
        cityBox.type(accountInformation.getCity());
        zipcodeBox.type(accountInformation.getZipcode());
        mobileNumberBox.type(accountInformation.getMobileNumber());
        createAccountButton.click();

        return initPage(getDriver(), AccountCreatedPageBase.class);

    }
}
