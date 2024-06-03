package com.solvd.gui.components.checkout;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddressBase extends AbstractUIObject {

    @FindBy(xpath = ".//li[contains(@class, 'firstname')]")
    private ExtendedWebElement addressPersonDetails;

    @FindBy(xpath = ".//li[contains(@class, 'address1')]")
    private ExtendedWebElement addressStreet;

    @FindBy(xpath = ".//li[contains(@class, 'city')]")
    private ExtendedWebElement addressDetails;

    @FindBy(xpath = ".//li[contains(@class, 'country')]")
    private ExtendedWebElement addressCountry;

    @FindBy(xpath = ".//li[contains(@class, 'phone')]")
    private ExtendedWebElement addressPhone;

    public AddressBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getAddressPersonDetails() {
        return addressPersonDetails;
    }

    public ExtendedWebElement getAddressStreet() {
        return addressStreet;
    }

    public ExtendedWebElement getAddressDetails() {
        return addressDetails;
    }

    public ExtendedWebElement getAddressCountry() {
        return addressCountry;
    }

    public ExtendedWebElement getAddressPhone() {
        return addressPhone;
    }

}
