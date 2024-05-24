package com.solvd.gui.pages.desktop;

import com.solvd.gui.components.featuresitems.FeaturesItems;
import com.solvd.gui.components.header.Header;
import com.solvd.gui.components.product.Product;
import com.solvd.gui.config.ConfigManager;
import com.solvd.gui.pages.common.CartPageBase;
import com.solvd.gui.pages.common.HomePageBase;
import com.solvd.gui.pages.common.SignupLoginPageBase;
import com.solvd.gui.pages.common.SignupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

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
        int index = rand.nextInt(featuresItems.getProducts().size());

        LOGGER.info("addRandomProductToCart(" + index + ")");

        Product product = featuresItems.getProducts().get(index);
        product.hoverOverProduct(index);
        product.clickAddToCartButton(index);
        product.clickContinueButton();
        return product.getProductDescription();

    }

    @Override
    public CartPageBase goToCart() {
        CartPageBase cartPageBase = header.openCartPage();
        return cartPageBase;
    }

    @Override
    public SignupPageBase signUp(String name, String email) {
        SignupLoginPageBase signupLoginPage = header.openSignupLoginPage();
        return signupLoginPage.createAccount(name, email);
    }

    @Override
    public HomePageBase login(String email, String password) {
        SignupLoginPageBase signupLoginPageBase = header.openSignupLoginPage();
        HomePageBase loggedHomePage = signupLoginPageBase.login(email, password);
        return loggedHomePage;
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public String getHomePageUrl() {
        LOGGER.info("getHomePageUrl() = " + homePageUrl);
        return homePageUrl;
    }

    @Override
    public FeaturesItems getFeaturesItems() {
        return featuresItems;
    }


}

