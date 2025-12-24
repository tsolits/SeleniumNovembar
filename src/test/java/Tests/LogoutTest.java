package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginSignupPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

        homePage = new HomePage();
        loginSignupPage = new LoginSignupPage();
    }

    @Test
    public void userCanLogout() {

        //ulogujem se
        homePage.clickOnLoginSignUpButton();
        loginSignupPage.inputEmailForLogin("iloveshopping@gmail.com");
        loginSignupPage.inputPasswordForLogin("123");
        loginSignupPage.clickOnLoginButton();

        // kliknem logout dugme
        homePage.clickOnLogoutButton();

        //proveravam da li je vidljivo polje za unos email-a,ako jeste znaci da sam se izlogovala
        Assert.assertTrue(
                loginSignupPage.isLoginEmailFieldDisplayed(), "Login email field is not displayed because user is not logged out!"
        );

        //proveravam da li su polja prazna,ako nisu vratim poruku
        Assert.assertTrue(loginSignupPage.getLoginEmailValue().isEmpty(), "Email field is not empty!");
        Assert.assertTrue(loginSignupPage.getLoginPasswordValue().isEmpty(), "Password field is not empty!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
