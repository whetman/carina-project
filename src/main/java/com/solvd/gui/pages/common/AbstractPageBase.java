package com.solvd.gui.pages.common;

import com.solvd.gui.components.featuresitems.FeaturesItems;
import com.solvd.gui.components.header.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPageBase extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPageBase.class);

    @FindBy(id = "header")
    private Header header;

    @FindBy(xpath = "//div[contains(@class, 'features')]")
    private FeaturesItems featuresItems;

    @FindBy(xpath = "//button[@type='submit']/preceding-sibling::p")
    protected ExtendedWebElement emailAlreadyExistsMessage;

    public AbstractPageBase(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        LOGGER.info("getHeader()");
        return header;
    }

    public FeaturesItems getFeaturesItems() {
        LOGGER.info("getFeaturesItems()");
        return featuresItems;
    }
}
