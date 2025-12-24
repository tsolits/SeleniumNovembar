package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static WebDriver driver;
    public HomePage homePage;
    public LoginSignupPage loginSignupPage;
    public InputInfoToCreateAccoutPage inputInfoToCreateAccoutPage;
    public CartPage cartPage;
    public AccountCreatedSuccessfullyPage accountCreatedSuccessfullyPage;
    public ViewProductPage viewProductPage;



    @BeforeClass
    public void setUpClass(){
        WebDriverManager.chromedriver().setup();

    }
}
