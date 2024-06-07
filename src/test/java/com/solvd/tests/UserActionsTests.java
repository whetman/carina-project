package com.solvd.tests;

import com.solvd.gui.components.cart.CartItem;
import com.solvd.gui.components.featuresitems.FeaturesItemsBase;
import com.solvd.gui.components.header.HeaderBase;
import com.solvd.gui.components.product.Product;
import com.solvd.gui.constants.Gender;
import com.solvd.gui.constants.ProductItems;
import com.solvd.gui.models.AccountInformation;
import com.solvd.gui.models.PaymentInformation;
import com.solvd.gui.pages.common.*;
import com.solvd.gui.pages.desktop.SignupPage;
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

    @DataProvider(name = "newAccountData")
    public Object[][] createAccountData() {
        return new Object[][]{
                {new AccountInformation("Wiktoria", "wiktoria999@email.com", Gender.MRS.getValue(), "password3", "26", "October", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Agata", "agata000@email.com", Gender.MRS.getValue(), "password3", "26", "October", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Maria", "maria000@email.com", Gender.MRS.getValue(), "password3", "26", "December", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
                {new AccountInformation("Ewa", "ewa000@email.com", Gender.MRS.getValue(), "password3", "26", "January", "1960", "Magdalena", "Ulica Sezamkowa 13", "New Zealand", "Statestate", "Auckland", "852587", "000000444")},
        };
    }

    @DataProvider(name = "accountData")
    public Object[][] loginData() {
        return new Object[][]{
                {"tadeusz@email.com", "password1", new PaymentInformation("Tadeusz Kowalski", "999999666666", "000", "12", "2300")},
                {"jolanta@email.com", "password2", new PaymentInformation("Jolanta Kowalska", "111222333444", "001", "11", "2036")},
                {"wiktoria999@email.com", "password1", new PaymentInformation("Wik wik", "777888999555", "002", "10", "2080")},
        };
    }

    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        return new Object[][]{
                {ProductItems.SHIRT.getValue()},
                {ProductItems.SKIRT.getValue()},
                {ProductItems.DRESS.getValue()},
                {ProductItems.BOOK.getValue()}
        };
    }

    @Test(testName = "#TC0001", description = "Verify that user can sign up", dataProvider = "newAccountData", priority = 1)
    public void validateSignUp(AccountInformation accountInfo) {

        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();

        if (homePage.getGoogleDataAgreementButton().isVisible()) {
            homePage.clickGoogleDataAgreementButton();
        }

        softAssert.assertTrue(homePage.getHeader().isDisplayed(), "Header is not displayed");

        SignupLoginPageBase signupLoginPage = homePage.getHeader().openSignupLoginPage();

        signupLoginPage.createAccount(accountInfo.getSignupName(), accountInfo.getSignupEmail());

        SignupPageBase signupPage = new SignupPage(getDriver());

        if (signupPage.getEmailAlreadyExistsMessage().isVisible() && signupPage.getEmailAlreadyExistsMessage().getText().contains("exist")) {
            softAssert.assertAll();
            assertTrue(true, "Account already exists");
        } else {
            AccountCreatedPageBase accountCreatedPage = signupPage.enterAccountInformation(accountInfo);
            HomePageBase homePageAfterAccountCreated = accountCreatedPage.continueAfterAccountCreated();
            AccountDeletedPageBase accountDeletedPage = homePageAfterAccountCreated.getHeader().deleteAccount();
            boolean displayed = accountDeletedPage.getAccountDeletedMessage().isDisplayed();
            softAssert.assertAll();
            assertTrue(displayed, "Account deleted message is not displayed");
        }
    }

    @Test(testName = "#TC0002", description = "Verify that logged user can add the product to the cart and buy it", dataProvider = "accountData")
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

    @Test(testName = "#TC0003", description = "Verify that search bar is working correctly", dataProvider = "searchData", priority = 0)
    public void verifySearchBar(String productName) {

        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();

        homePage.clickGoogleDataAgreementButton();

        HeaderBase header = homePage.getHeader();

        ProductsPageBase productsPage = header.openProductsPage();
        ProductsPageBase productsPageSearched = productsPage.typeInSearchBar(productName);

        softAssert.assertTrue(getDriver().getCurrentUrl().contains(productName), "Current url doesn't contain searched product name.");

        FeaturesItemsBase featuresItems = productsPageSearched.getFeaturesItems();

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

    @Test(testName = "#TC0004", description = "Verify that logged user can add multiple products of one kind to the cart", dataProvider = "accountData", priority = 0)
    public void verifyAddingMultipleProducts(String email, String password, PaymentInformation paymentInformation) {

        SoftAssert softAssert = new SoftAssert();

        HomePageBase homePage = openHomePage();

        homePage.clickGoogleDataAgreementButton();

        homePage.login(email, password);

        ItemPageBase itemPage = homePage.viewRandomProductInformation();

        Random random = new Random();
        int q = random.nextInt(1, 50);
        String quantity = "" + q;

        itemPage.changeQuantity(quantity);

        CartPageBase cartPage = itemPage.addToCart();
        List<CartItem> cartItems = cartPage.getCart().getCartItems();

        //todo fix not to be hardcoded
        String quantityInCart = cartItems.get(0).getCartItemQuantity().getText();

        softAssert.assertTrue(quantityInCart.equals(quantity), "Quantity in cart is different than quantity typed");
        softAssert.assertAll();

    }
}

