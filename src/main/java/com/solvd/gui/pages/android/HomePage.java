package com.solvd.gui.pages.android;

import com.solvd.gui.components.product.ProductBase;
import com.solvd.gui.config.ConfigManager;
import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.ItemPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
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

        Random rand = new Random();
        int index = rand.nextInt(getFeaturesItems().getProduct().size());

        LOGGER.info("addRandomProductToCart(" + index + ")");

        ProductBase productAndroid = getFeaturesItems().getProduct().get(index);
        productAndroid.click();
        productAndroid.getProductButton().get(index).click();
        productAndroid.clickContinueButton();
        return productAndroid.productDescriptionText();
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

