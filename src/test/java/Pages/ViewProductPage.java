package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewProductPage extends BaseTest {

    public ViewProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button.cart")
    public WebElement addToCartButton;

    @FindBy(css = "a[href='/view_cart']")
    public WebElement cartButton;

    @FindBy(css = "div.modal-body a[href='/view_cart']")
    public WebElement viewCartFromModalButton;


    //----------------------------

    public void clickOnAddToCart(){
        addToCartButton.click();
    }

    public void clickOnCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
    }

    public void clickOnViewCartFromModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(viewCartFromModalButton));
        viewCartFromModalButton.click();
    }



}
