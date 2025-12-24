package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ViewProductPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");

        homePage = new HomePage();
        cartPage = new CartPage();
        viewProductPage=new ViewProductPage();

    }


    @Test  // Test koji proverava da li je korpa prazna pre nego što dodamo proizvod
    public void verifyCartIsEmptyBeforeAddingProduct() {

        homePage.clickOnCartButton();

        Assert.assertTrue(   //  proverava da li metoda isCartEmpty() vraća true. Ako ne, javlja poruku.
                cartPage.isCartEmpty(), "Cart is NOT empty before adding any product!"
        );

        Assert.assertTrue(   // proverava da li tekst elementa koji prikazuje poruku prazne korpe sadrži "Cart is empty".
                cartPage.emptyCartMessage.getText()
                        .contains("Cart is empty"), "Empty cart message text is incorrect!"
        );

    }


    @Test
    public void removeAllProductsFromCart() {

        homePage.clickOnFirstViewProductButton();
        viewProductPage.clickOnAddToCart();
        viewProductPage.clickOnViewCartFromModal();


        Assert.assertTrue(
                cartPage.isProductInCart(),
                "Products are NOT displayed in cart after adding"
        );

        // briše sve proizvode iz cart-a
        cartPage.deleteAllProductsFromCart();

        Assert.assertTrue(
                cartPage.isCartEmpty(),
                "Cart is NOT empty after removing all products"
        );
    }

    @Test
    public void deleteProductByIndex(){
        homePage.clickOnFirstViewProductButton();
        viewProductPage.clickOnAddToCart();
        viewProductPage.clickOnViewCartFromModal();
        cartPage.deleteProductByIndex(0);
        cartPage.waitForCartToBeEmpty(); // čekamo da DOM update-uje stanje korpe

        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is NOT empty after removing product");

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
