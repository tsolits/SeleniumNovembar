package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginSignupPage extends BaseTest {

    public LoginSignupPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[data-qa='login-email']")
    public WebElement loginEmailField;

    @FindBy(css = "input[data-qa='login-password']")
    public WebElement loginPasswordField;

    @FindBy(css = "button[data-qa='login-button']")
    public WebElement loginButton;

    //-------

    @FindBy(css = "input[data-qa='signup-name']")
    public WebElement signupNameField;

    @FindBy (css = "input[data-qa='signup-email']")
    public WebElement signupEmailField;

    @FindBy(css = "button[data-qa='signup-button']")
    public WebElement signupButton;

    //-------

    //trazim sve crvene error poruke (login i signup)
    @FindBy(css = "p[style*='color']")
    public List<WebElement> errorMessages;


    //----------------------------------------------------------

    public void inputEmailForLogin(String loginEmail){
        loginEmailField.clear();
        loginEmailField.sendKeys(loginEmail);
    }

    public void inputPasswordForLogin(String loginPassword){
        loginPasswordField.clear();
        loginPasswordField.sendKeys(loginPassword);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void inputNameForSignup(String name){
        signupNameField.clear();
        signupNameField.sendKeys(name);
    }

    public void inputEmailForSignup(String email){
        signupEmailField.clear();
        signupEmailField.sendKeys(email);
    }

    public void clickOnSignupButton(){
        signupButton.click();
    }

    //-------

    //LOGIN proveravamo da li je prikazana poruka greške kada je email ili lozinka pogrešna
    public boolean isLoginErrorDisplayed() {
        // Prolazimo kroz listu svih elemenata koji mogu prikazivati greške na stranici
        for (WebElement message : errorMessages) {
            // Ako tekst elementa sadrži tačnu poruku o pogrešnom emailu ili lozinki
            if (message.getText().contains("Your email or password is incorrect!")) {
                // Vraćamo true jer je greška prikazana
                return true;
            }
        }
        // Ako nijedan element ne sadrži poruku, vraćamo false
        return false;
    }

    //SIGN UP proveravamo da li je prikazana greška kada email već postoji
    public boolean isSignupEmailExistsErrorDisplayed() {
        for (WebElement message : errorMessages) {
            if (message.getText().contains("Email Address already exist!")) {
                return true;
            }
        }
        return false;
    }

    // Vraća trenutnu vrednost (tekst) u email polju
    public String getLoginEmailValue() {
        return loginEmailField.getAttribute("value");
    }

    // Vraća tekst iz polja lozinke
    public String getLoginPasswordValue() {
        return loginPasswordField.getAttribute("value");
    }

    // Vraća true ili false u zavisnosti da li je polje vidljivo
    public boolean isLoginEmailFieldDisplayed() {
        return loginEmailField.isDisplayed();
    }


  }

