package com.solvd.gui.pages.desktop;

import com.solvd.gui.constants.Gender;
import com.solvd.gui.models.AccountInformation;
import com.solvd.gui.pages.common.SignupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignupPageBase.class)
public class SignupPage extends SignupPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupPage.class);

    @FindBy(id = "id_gender1")
    private ExtendedWebElement titleMr;

    @FindBy(id = "id_gender2")
    private ExtendedWebElement titleMrs;

    @FindBy(id = "password")
    private ExtendedWebElement passwordBox;

    @FindBy(id = "days")
    private ExtendedWebElement daysDropdown;

    @FindBy(xpath = "//select[@id='days']//option")
    private List<ExtendedWebElement> days;

    @FindBy(id = "months")
    private ExtendedWebElement monthsDropdown;

    @FindBy(xpath = "//select[@id='months']//option")
    private List<ExtendedWebElement> months;

    @FindBy(id = "years")
    private ExtendedWebElement yearsDropdown;

    @FindBy(xpath = "//select[@id='years']//option")
    private List<ExtendedWebElement> years;

    @FindBy(id = "first_name")
    private ExtendedWebElement firstNameBox;

    @FindBy(id = "last_name")
    private ExtendedWebElement lastnameNameBox;

    @FindBy(id = "address1")
    private ExtendedWebElement addressBox;

    @FindBy(id = "country")
    private ExtendedWebElement countryDropdown;

    @FindBy(xpath = "//select[@id='country']//option")
    private List<ExtendedWebElement> countries;

    @FindBy(id = "state")
    private ExtendedWebElement stateBox;

    @FindBy(id = "city")
    private ExtendedWebElement cityBox;

    @FindBy(id = "zipcode")
    private ExtendedWebElement zipcodeBox;

    @FindBy(id = "mobile_number")
    private ExtendedWebElement mobileNumberBox;

    @FindBy(xpath = "//form[contains(@action, 'signup')]//button")
    private ExtendedWebElement createAccountButton;

    @FindBy(xpath = "//div[contains(@class, 'login')]")
    private ExtendedWebElement loginForm;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterAccountInformation(AccountInformation accountInformation) {

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

    }
}
