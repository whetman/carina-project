package com.solvd.gui.pages.common;

import com.solvd.gui.components.featuresitems.FeaturesItems;
import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.header.HeaderBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePageBase extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    @FindBy(id = "header")
    protected Header header;

    @FindBy(xpath = "//div[contains(@class, 'features')]")
    protected FeaturesItems featuresItems;

    @FindBy(xpath = "(//p[@class='fc-button-label'])[1]")
    protected ExtendedWebElement googleDataAgreementButton;

    public HomePageBase(WebDriver driver) {
        super(driver);
        //what is it
        //setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract HeaderBase getHeader();

    public abstract String getHomePageUrl();

    public abstract FeaturesItems getFeaturesItems();

    public abstract String addRandomProductToCart();

    public abstract CartPageBase goToCart();

    public abstract SignupPageBase signUp(String name, String email);

    public abstract void clickGoogleDataAgreementButton();

    public abstract HomePageBase login(String email, String password);

    public abstract HomePageBase deleteAccount();

    @Override
    public void open() {
        super.open();
    }

}
