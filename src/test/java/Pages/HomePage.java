package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/login']")
    public WebElement loginSignUpButton;

    @FindBy(css = "a[href='/view_cart']")
    public WebElement viewCartButton;

    @FindBy(css = "a[data-product-id='1']")
    public WebElement addToCartButton;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    @FindBy(css = "a[href*='product_details']")
    public List<WebElement> viewProductButtons;



    //------------------------------------------------------------------------------

    public void clickOnLoginSignUpButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(loginSignUpButton));
        loginSignUpButton.click();
    }

    public void clickOnCartButton(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        viewCartButton.click();
    }

    public void clickOnFirstViewProductButton() {

        // scroll do dugmeta
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", viewProductButtons.get(0));

        // cekam da dugme bude klikabilno
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(viewProductButtons.get(0)));

        // klik
        viewProductButtons.get(0).click();
    }


    public void clickOnLogoutButton(){
        logoutButton.click();
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }


    //driver.findElements(...) vraća listu svih elemenata koji odgovaraju selektoru (a[href='/login']).
    //Ako element ne postoji, metoda neće baciti exception
    //size() > 0 znači: “ako postoji bar jedan takav element, vrati true, inače false”
    public boolean isLoginSignupButtonPresent() {
        return driver.findElements(By.cssSelector("a[href='/login']")).size() > 0;
    }


}






    //u ovoj metodi isDisplayed() će baciti exception ako element ne postoji u DOM(Document Object Mode) posle login-a.
    // DOM predstavlja strukturu web stranice kao objektnu hijerarhiju.
//    @FindBy(css = "a[href='/login']")
//    private WebElement loginSignupButton;
//
//    public boolean isLoginSignupButtonDisplayed() {
//        return loginSignupButton.isDisplayed();
//    }



