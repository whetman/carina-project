package com.solvd.gui.pages.common;

import com.solvd.gui.components.featuresitems.FeaturesItems;
import com.solvd.gui.components.header.HeaderBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePageBase extends AbstractPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    @FindBy(xpath = "(//p[@class='fc-button-label'])[1]")
    protected ExtendedWebElement googleDataAgreementButton;

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getHomePageUrl();

    public abstract String addRandomProductToCart();

    public abstract CartPageBase goToCart();

    public abstract void clickGoogleDataAgreementButton();

    public abstract HomePageBase login(String email, String password);

    @Override
    public void open() {
        super.open();
    }

}
