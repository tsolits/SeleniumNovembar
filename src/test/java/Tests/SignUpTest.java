package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest extends BaseTest {

    @BeforeMethod
    public void PageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

        homePage=new HomePage();
        loginSignupPage=new LoginSignupPage();
        inputInfoToCreateAccoutPage=new InputInfoToCreateAccoutPage();
        accountCreatedSuccessfullyPage=new AccountCreatedSuccessfullyPage();

    }

    @Test
    public void userCanSignup(){
        homePage.clickOnLoginSignUpButton();


        loginSignupPage.inputNameForSignup("shoppingmaniia");
        loginSignupPage.inputEmailForSignup("iloveshoppiing@gmail.com");
        loginSignupPage.clickOnSignupButton();

        inputInfoToCreateAccoutPage.waitForAccountInfoPageToLoad();


        inputInfoToCreateAccoutPage.clickOnSelectTitleGenderButton(1);  //0 ili 1
        inputInfoToCreateAccoutPage.inputPasswordField("123");
        inputInfoToCreateAccoutPage.inputFirstName("Ni");
        inputInfoToCreateAccoutPage.inputLastName("Na");
        inputInfoToCreateAccoutPage.inputCompany("CDD Works");
        inputInfoToCreateAccoutPage.inputState("Texas");
        inputInfoToCreateAccoutPage.inputCity("Austin");
        inputInfoToCreateAccoutPage.inputZipcode("73301");
        inputInfoToCreateAccoutPage.inputPhoneNumber("0656347246");
        inputInfoToCreateAccoutPage.inputAddress1("Summerstreet 20");
        inputInfoToCreateAccoutPage.inputAddress2("Sunnystreet 10");
        inputInfoToCreateAccoutPage.selectDayOfBirth("25");
        inputInfoToCreateAccoutPage.selectMonthOfBirth("12");
        inputInfoToCreateAccoutPage.selectYearOfBirth("2000");
        inputInfoToCreateAccoutPage.selectCountry("United States");
        inputInfoToCreateAccoutPage.clickOnCreateAccountButton();


        //proveravam da li sam uspesno napravila account tako sto proveravam da li se pojavila poruka "Account Created"
        String message = accountCreatedSuccessfullyPage.getSuccessMessageText();
        Assert.assertTrue(message.contains("Account Created"), "Account was not created successfully!");

    }



    @Test
    public void userCannotSignupWithExistingEmail() {

        homePage.clickOnLoginSignUpButton();

        loginSignupPage.inputNameForSignup("shoppingmania");
        loginSignupPage.inputEmailForSignup("iloveshopping@gmail.com"); // već registrovan email
        loginSignupPage.clickOnSignupButton();



        // proveravamo da li je prikazana greška kada email već postoji
        Assert.assertTrue(
                loginSignupPage.isSignupEmailExistsErrorDisplayed(),
                "Signup allowed with existing email!"
        );

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}
