package com.solvd.gui.pages.common;

import com.solvd.gui.components.featuresitems.FeaturesItems;
import com.solvd.gui.components.header.HeaderBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePageBase extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    public HomePageBase(WebDriver driver) {
        super(driver);
        //what is it
        //setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract HeaderBase getHeader();
    public abstract String getHomePageUrl();
    public abstract FeaturesItems getFeaturesItems();
    public abstract void addRandomProductToCart();
    public abstract void goToCart();
    public abstract SignupPageBase signUp(String name, String email);

    @Override
    public void open() {
        super.open();
    }
}
