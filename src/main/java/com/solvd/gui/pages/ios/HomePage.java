package com.solvd.gui.pages.ios;

import com.solvd.gui.components.product.ProductBase;
import com.solvd.gui.config.ConfigManager;
import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.ItemPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    private ConfigManager configManager = new ConfigManager();
    private String homePageUrl;

    public HomePage(WebDriver driver) {
        super(driver);
        LOGGER.info("HomePage()");
        this.homePageUrl = configManager.getProperty("url");
    }

    @Override
    public String addRandomProductToCart() {

        waitUntil(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class='product-image-wrapper']")), 10L);

        Random rand = new Random();
        int index = rand.nextInt(getFeaturesItems().getProduct().size());

        LOGGER.info("addRandomProductToCart(" + index + ")");

        ProductBase product = getFeaturesItems().getProduct().get(index);
        product.scrollTo();
        product.click();
        product.getProductButtonIOS().get(index).click();
        product.getContinueButton().scrollTo();
        product.clickContinueButton();
        return product.productDescriptionText();
    }

    @Override
    public CartPageBase goToCart() {
        LOGGER.info("goToCart()");
        getHeader().scrollTo();
        CartPageBase cartPageBase = getHeader().openCartPage();
        return cartPageBase;
    }

    @Override
    public ItemPageBase viewRandomProductInformation() {
        LOGGER.info("viewProductInformation()");
        Random rand = new Random();
        int index = rand.nextInt(getFeaturesItems().getProduct().size());

        ItemPageBase itemPage = getFeaturesItems().getProduct().get(index).clickViewProduct();

        return itemPage;
    }
}

