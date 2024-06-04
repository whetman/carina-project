package com.solvd.tests;

import com.solvd.gui.components.cart.CartItem;
import com.solvd.gui.components.featuresitems.FeaturesItems;
import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.components.product.Product;
import com.solvd.gui.constants.Gender;
import com.solvd.gui.constants.ProductItems;
import com.solvd.gui.models.AccountInformation;
import com.solvd.gui.models.PaymentInformation;
import com.solvd.gui.pages.common.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.testng.Assert.assertTrue;

public class UserActionsTests extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserActionsTests.class);

    @DataProvider(name = "newAccountData", parallel = true)
    public Object[][] createAccountData() {
        return new Object[][]{
                {new AccountInformation("Wiktoria", "wiktoria999@email.com", Gender.MRS.getValue(), "password3", "26", "October", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                //{new AccountInformation("Agata", "agata000@email.com", Gender.MRS.getValue(), "password3", "26", "October", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                //{new AccountInformation("Maria", "maria000@email.com", Gender.MRS.getValue(), "password3", "26", "December", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                //{new AccountInformation("Ewa", "ewa000@email.com", Gender.MRS.getValue(), "password3", "26", "January", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
        };
    }

    @DataProvider(name = "accountData", parallel = true)
    public Object[][] loginData() {
        return new Object[][]{
                {"tadeusz@email.com", "password1", new PaymentInformation("Tadeusz Kowalski", "999999666666", "000", "12", "2300")},
                {"jolanta@email.com", "password2", new PaymentInformation("Jolanta Kowalska", "111222333444", "001", "11", "2036")},
                {"wiktoria999@email.com", "password1", new PaymentInformation("Wik wik", "777888999555", "002", "10", "2080")},
        };
    }

    @DataProvider(name = "searchData", parallel = true)
    public Object[][] searchData() {
        return new Object[][]{
                {ProductItems.SHIRT.getValue()},
                {ProductItems.SKIRT.getValue()},
                {ProductItems.DRESS.getValue()},
                {ProductItems.BOOK.getValue()}
        };
    }

    @Test(testName = "#TC0002", description = "Verify that logged user can add the product to the cart and buy it", dataProvider = "accountData", priority = 0, threadPoolSize = 2, invocationCount = 2)
    public void verifyAddingProductsAndBuying(String email, String password, PaymentInformation paymentInformation) {
        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();

        homePage.clickGoogleDataAgreementButton();

        homePage.login(email, password);

        String productAdded = homePage.addRandomProductToCart();
        String productAddedTwo = homePage.addRandomProductToCart();
        String productAddedThree = homePage.addRandomProductToCart();

        CartPageBase cartPageBase = homePage.goToCart();

        List<String> productsAdded = Arrays.asList(productAdded, productAddedTwo, productAddedThree);

        IntStream.range(0, productsAdded.size())
                .forEach(i -> {
                    String cartItemDescription = cartPageBase.getCartItemDescription(i);
                    softAssert.assertTrue(cartItemDescription.contains(productsAdded.get(i)), "Products are not the same");
                });

        CheckoutPageBase checkoutPage = cartPageBase.buyProducts();
        boolean areAddressesCorrect = checkoutPage.areAddressesCorrect();

        softAssert.assertTrue(areAddressesCorrect, "Billing address and delivery address are not the same");

        PaymentPageBase paymentPage = checkoutPage.placeOrder();
        PaymentDonePageBase paymentDonePageBase = paymentPage.enterPaymentDetailsAndContinue(
                paymentInformation.getNameOnCard(),
                paymentInformation.getCardNumber(),
                paymentInformation.getCvcNumber(),
                paymentInformation.getExpirationMonth(),
                paymentInformation.getExpirationYear());

        softAssert.assertAll();

        assertTrue(paymentDonePageBase.getInvoiceButton().isDisplayed(), "Invoice button is not displayed");
    }

    @Test(testName = "#TC0003", description = "Verify that search bar is working correctly", dataProvider = "searchData", priority = 0, threadPoolSize = 2, invocationCount = 2)
    public void verifySearchBar(String productName) {

        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();

        homePage.clickGoogleDataAgreementButton();

        HeaderBase header = homePage.getHeader();

        ProductsPageBase productsPage = header.openProductsPage();
        ProductsPageBase productsPageSearched = productsPage.typeInSearchBar(productName);

        softAssert.assertTrue(getDriver().getCurrentUrl().contains(productName), "Current url doesn't contain searched product name.");

        FeaturesItems featuresItems = productsPageSearched.getFeaturesItems();

        LOGGER.info("###SIZE: " + featuresItems.getProducts().size() + "n: " + productName);

        List<Product> products = featuresItems.getProducts();


        switch (productName) {
            case "shirt":
            case "dress":
                softAssert.assertTrue(products.size() > 0, "Size of the list is 0");
                break;
            case "skirt":
            case "book":
                softAssert.assertTrue(products.size() == 0, "Size of the list is more than 0");
                break;
        }

        softAssert.assertAll();

    }

    //todo fix - sometimes element not clickable
    @Test(testName = "#TC0004", description = "Verify that logged user can add multiple products of one kind to the cart", dataProvider = "accountData", priority = 0, threadPoolSize = 2, invocationCount = 2)
    public void verifyAddingMultipleProducts(String email, String password, PaymentInformation paymentInformation) {

        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();

        homePage.clickGoogleDataAgreementButton();

        homePage.login(email, password);

        Random random = new Random();
        int i = random.nextInt(1, 15);

        List<Product> products = homePage.getFeaturesItems().getProducts();
        int size = products.size();

        Product product = products.get(i);
        boolean clickable = product.getViewProduct().isClickable();

        ItemPageBase itemPage = product.clickViewProduct();

        int q = random.nextInt(1, 50);
        String quantity = "" + q;

        itemPage.changeQuantity(quantity);
        CartPageBase cartPage = itemPage.addToCart();
        List<CartItem> cartItems = cartPage.getCart().getCartItems();
        String quantityInCart = cartItems.get(1).getCartItemQuantity().getText();

        softAssert.assertTrue(quantityInCart.equals(quantity), "Quantity in cart is different than quantity typed");
        softAssert.assertAll();

    }
}

