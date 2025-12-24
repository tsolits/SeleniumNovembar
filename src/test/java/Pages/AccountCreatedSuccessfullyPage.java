package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BaseTest;

public class AccountCreatedSuccessfullyPage extends BaseTest {

    public AccountCreatedSuccessfullyPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h2[data-qa='account-created']")
    private WebElement successMessage;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    //-----------------------------------------------------------

    // metoda koja vraća tekst poruke
    public String getSuccessMessageText() {
        return successMessage.getText();
    }

    // metoda koja vraća da li je dugme Continue vidljivo
    public boolean isContinueButtonDisplayed() {
        return continueButton.isDisplayed();
    }

    // metoda za klik na Continue dugme
    public void clickContinue() {
        continueButton.click();
    }
}
