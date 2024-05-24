package com.solvd.gui.pages.common;

import com.solvd.gui.models.AccountInformation;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class SignupPageBase extends AbstractPage {

    @FindBy(id = "id_gender1")
    protected ExtendedWebElement titleMr;

    @FindBy(id = "id_gender2")
    protected ExtendedWebElement titleMrs;

    @FindBy(id = "password")
    protected ExtendedWebElement passwordBox;

    @FindBy(id = "days")
    protected ExtendedWebElement daysDropdown;

    @FindBy(xpath = "//select[@id='days']//option")
    protected List<ExtendedWebElement> days;

    @FindBy(id = "months")
    protected ExtendedWebElement monthsDropdown;

    @FindBy(xpath = "//select[@id='months']//option")
    protected List<ExtendedWebElement> months;

    @FindBy(id = "years")
    protected ExtendedWebElement yearsDropdown;

    @FindBy(xpath = "//select[@id='years']//option")
    protected List<ExtendedWebElement> years;

    @FindBy(id = "first_name")
    protected ExtendedWebElement firstNameBox;

    @FindBy(id = "last_name")
    protected ExtendedWebElement lastnameNameBox;

    @FindBy(id = "address1")
    protected ExtendedWebElement addressBox;

    @FindBy(id = "country")
    protected ExtendedWebElement countryDropdown;

    @FindBy(xpath = "//select[@id='country']//option")
    protected List<ExtendedWebElement> countries;

    @FindBy(id = "state")
    protected ExtendedWebElement stateBox;

    @FindBy(id = "city")
    protected ExtendedWebElement cityBox;

    @FindBy(id = "zipcode")
    protected ExtendedWebElement zipcodeBox;

    @FindBy(id = "mobile_number")
    protected ExtendedWebElement mobileNumberBox;

    @FindBy(xpath = "//form[contains(@action, 'signup')]//button")
    protected ExtendedWebElement createAccountButton;

    @FindBy(xpath = "//div[contains(@class, 'login')]")
    protected ExtendedWebElement loginForm;

    public SignupPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterAccountInformation(AccountInformation accountInformation);
}
