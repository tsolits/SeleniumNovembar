package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InputInfoToCreateAccoutPage extends BaseTest {

    public InputInfoToCreateAccoutPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="title")
    List<WebElement> selectTitleGenderButton;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(id="days")
    WebElement dayOfBirthDropdownMenu;

    @FindBy(id="months")
    WebElement monthOfBirthDropdownMenu;

    @FindBy(id="years")
    WebElement yearOfBirthDropdownMenu;

    @FindBy(id="first_name")
    WebElement firstNameField;

    @FindBy(id="last_name")
    WebElement lastNameField;

    @FindBy(id="company")
    WebElement companyField;

    @FindBy(id="address1")
    WebElement addressField1;

    @FindBy(id="address2")
    WebElement addressField2;

    @FindBy(id = "country")
    WebElement countryDropdownMenu;

    @FindBy(id="state")
    WebElement stateField;

    @FindBy(id="city")
    WebElement cityField;

    @FindBy(id="zipcode")
    WebElement zipCodeField;

    @FindBy(id="mobile_number")
    WebElement phoneNumberField;

    @FindBy(css = "button[data-qa='create-account']")
    WebElement createAccountButton;

    //----------------------------------------------------------



    public void waitForAccountInfoPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
    }


    public void clickOnSelectTitleGenderButton(int index){
        selectTitleGenderButton.get(index).click();
    }

    public void inputPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void selectDayOfBirth(String dayOfBirth){
        Select day=new Select(dayOfBirthDropdownMenu);
        day.selectByValue(dayOfBirth);
    }

    public void selectMonthOfBirth(String monthOfBirth){
        Select month = new Select(monthOfBirthDropdownMenu);
        month.selectByValue(monthOfBirth);
    }

    public void selectYearOfBirth(String yearOfBirth){
        Select year = new Select(yearOfBirthDropdownMenu);
        year.selectByValue(yearOfBirth);

    }

    public void inputFirstName(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputCompany(String companyName){
        companyField.clear();
        companyField.sendKeys(companyName);
    }

    public void inputAddress1(String address1){
        addressField1.clear();
        addressField1.sendKeys(address1);
    }

    public void inputAddress2(String address2){
        addressField2.clear();
        addressField2.sendKeys(address2);
    }

    public void inputState(String state){
        stateField.clear();
        stateField.sendKeys(state);
    }

    public void inputCity(String city){
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void inputZipcode(String zipcode){
        zipCodeField.clear();
        zipCodeField.sendKeys(zipcode);
    }

    public void inputPhoneNumber(String phoneNumber){
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void selectCountry(String countryName){
        Select country = new Select(countryDropdownMenu);
        country.selectByValue(countryName);
    }

    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }

}
