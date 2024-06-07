package com.solvd.gui.pages.common;

import com.solvd.gui.components.featuresitems.FeaturesItems;
import com.solvd.gui.components.featuresitems.FeaturesItemsBase;
import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.header.HeaderBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPageBase extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPageBase.class);

    @FindBy(id = "com.android.chrome:id/menu_button")
    private ExtendedWebElement chromeMenuButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.android.chrome:id/menu_item_text\" and @text=\"Downloads\"]")
    private ExtendedWebElement chromeDownloads;

    @FindBy(id = "header")
    private Header header;

    @FindBy(xpath = "//div[contains(@class, 'features')]")
    private FeaturesItems featuresItems;

    @FindBy(id = "com.android.chrome:id/title")
    private ExtendedWebElement invoice;

    public AbstractPageBase(WebDriver driver) {
        super(driver);
    }

    public HeaderBase getHeader() {
        LOGGER.info("getHeader()");
        return header;
    }

    public FeaturesItemsBase getFeaturesItems() {
        LOGGER.info("getFeaturesItems()");
        return featuresItems;
    }

    public ExtendedWebElement getChromeMenuButton() {
        return chromeMenuButton;
    }

    public ExtendedWebElement getChromeDownloads() {
        return chromeDownloads;
    }

    public ExtendedWebElement getInvoice() {
        return invoice;
    }
}
