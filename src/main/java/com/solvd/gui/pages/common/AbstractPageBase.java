package com.solvd.gui.pages.common;

import com.solvd.gui.components.featuresitems.FeaturesItems;
import com.solvd.gui.components.header.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractPageBase extends AbstractPage {

    @FindBy(id = "header")
    protected Header header;

    @FindBy(xpath = "//div[contains(@class, 'features')]")
    protected FeaturesItems featuresItems;

    public AbstractPageBase(WebDriver driver) {
        super(driver);
    }

}
