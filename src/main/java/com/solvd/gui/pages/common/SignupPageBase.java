package com.solvd.gui.pages.common;

import com.solvd.gui.models.AccountInformation;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class SignupPageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupPageBase.class);

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

    public SignupPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AccountCreatedPageBase enterAccountInformation(AccountInformation accountInformation);

    public ExtendedWebElement getTitleMr() {
        LOGGER.info("getTitleMr()");
        return titleMr;
    }

    public ExtendedWebElement getTitleMrs() {
        LOGGER.info("getTitleMrs()");
        return titleMrs;
    }

    public ExtendedWebElement getPasswordBox() {
        LOGGER.info("getPasswordBox()");
        return passwordBox;
    }

    public ExtendedWebElement getDaysDropdown() {
        LOGGER.info("getDaysDropdown()");
        return daysDropdown;
    }

    public List<ExtendedWebElement> getDays() {
        LOGGER.info("getDays()");
        return days;
    }

    public ExtendedWebElement getMonthsDropdown() {
        LOGGER.info("getMonthsDropdown()");
        return monthsDropdown;
    }

    public List<ExtendedWebElement> getMonths() {
        LOGGER.info("getMonths()");
        return months;
    }

    public ExtendedWebElement getYearsDropdown() {
        LOGGER.info("getYearsDropdown()");
        return yearsDropdown;
    }

    public List<ExtendedWebElement> getYears() {
        LOGGER.info("getYears()");
        return years;
    }

    public ExtendedWebElement getFirstNameBox() {
        LOGGER.info("getFirstNameBox()");
        return firstNameBox;
    }

    public ExtendedWebElement getLastnameNameBox() {
        LOGGER.info("getLastnameNameBox()");
        return lastnameNameBox;
    }

    public ExtendedWebElement getAddressBox() {
        LOGGER.info("getAddressBox()");
        return addressBox;
    }

    public List<ExtendedWebElement> getCountries() {
        LOGGER.info("getCountries()");
        return countries;
    }

    public ExtendedWebElement getCountryDropdown() {
        LOGGER.info("getCountryDropdown()");
        return countryDropdown;
    }

    public ExtendedWebElement getStateBox() {
        LOGGER.info("getStateBox()");
        return stateBox;
    }

    public ExtendedWebElement getCityBox() {
        LOGGER.info("getCityBox()");
        return cityBox;
    }

    public ExtendedWebElement getZipcodeBox() {
        LOGGER.info("getZipcodeBox()");
        return zipcodeBox;
    }

    public ExtendedWebElement getMobileNumberBox() {
        LOGGER.info("getMobileNumberBox()");
        return mobileNumberBox;
    }

    public ExtendedWebElement getCreateAccountButton() {
        LOGGER.info("getCreateAccountButton()");
        return createAccountButton;
    }

    public ExtendedWebElement getLoginForm() {
        LOGGER.info("getLoginForm()");
        return loginForm;
    }
}
