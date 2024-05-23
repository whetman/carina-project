package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    @FindBy(id = "header")
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Header getHeader() {
        return header;
    }

}

