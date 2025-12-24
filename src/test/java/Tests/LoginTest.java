package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void PageSetUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

        homePage=new HomePage();
        loginSignupPage=new LoginSignupPage();
        accountCreatedSuccessfullyPage=new AccountCreatedSuccessfullyPage();

    }

    @Test
    public void userCanLoginWithValidCredentials(){

        homePage.clickOnLoginSignUpButton();
        loginSignupPage.inputPasswordForLogin("123");
        loginSignupPage.inputEmailForLogin("iloveshopping@gmail.com");
        loginSignupPage.clickOnLoginButton();


        // proveravam da li je vidljivo logout dugme,ako je vidljivo znaci da je user je ulogovan
        Assert.assertTrue(
                homePage.isLogoutButtonDisplayed(), "Logout button is not displayed – login failed!"
        );

        //proveravam dal je vidljivo signup dugme,ako je vidljivo znaci da user nije ulogovan
        Assert.assertFalse(
                homePage.isLoginSignupButtonPresent(), "Login / Signup button is still visible – user is NOT logged in!"
        );

    }




    @Test
    public void userCannotLoginWithInvalidEmailOrPassword() {

        homePage.clickOnLoginSignUpButton();

        loginSignupPage.inputEmailForLogin("wrongemail@gmail.com");
        loginSignupPage.inputPasswordForLogin("wrongPassword123");
        loginSignupPage.clickOnLoginButton();


        // proveravamo da li je prikazana poruka greške kada je email ili lozinka pogrešna
        Assert.assertTrue(
                loginSignupPage.isLoginErrorDisplayed(),
                "User logged in with invalid email or password!"
        );


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
