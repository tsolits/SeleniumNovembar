package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    // napravila sam listu svih proizvoda u cartu (tr id počinje sa 'product-')
    @FindBy(css = "tr[id^='product-']")
    public List<WebElement> productsInCart;

    // dugme za brisanje proizvoda
    @FindBy(css = "tr[id^='product-'] .cart_delete a")
    public List<WebElement> deleteButtons;

    // poruka kada je cart prazan
    @FindBy(css = ".text-center")
    public WebElement emptyCartMessage;

    //--------------------------------

    public void waitForCartToBeEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> {
            //Pozivamo wait.until() da izvršava proveru dok uslov ne bude ispunjen ili dok ne istekne timeout
            // nema proizvoda u cart-u ili je prikazana poruka prazne korpe
            return productsInCart.size() == 0 || emptyCartMessage.isDisplayed();
        });
    }


    // proverava da li postoji bar jedan proizvod u cart-u
    public boolean isProductInCart() {
        // Ako lista productsInCart ima bar jedan element, vraća true; inače false
        return productsInCart.size() > 0;
    }


    public boolean isCartEmpty() {
        try {
            // Vraća true ako je prikazana poruka prazne korpe ili ako lista productsInCart nema nijedan element
            return emptyCartMessage.isDisplayed() || productsInCart.size() == 0;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            // Ako element ne postoji ili je "stale" (nestao iz DOM-a), vraća false
            // Ovo sprečava da test padne zbog izuzetaka
            return false;
        }
    }


//    // proverava da li je cart prazan
//    public boolean isCartEmpty() {
//        return emptyCartMessage.isDisplayed();
//    }


    public void deleteAllProductsFromCart() {
        // Petlja se izvršava dok ima bar jednog dugmeta za brisanje proizvoda
        while (deleteButtons.size() > 0) {
            // Klik na prvo dugme za brisanje (uvek 0, jer se lista menja posle klika)
            deleteButtons.get(0).click();
            waitForCartToBeEmpty(); // dodaj čekanje da DOM update-uje listu
        }
    }


    // briše proizvod iz cart-a po zadatom indeksu
    public void deleteProductByIndex(int index) {
        // Provera da li je indeks validan (ne negativan i manji od broja dugmadi)
        if(index >= 0 && index < deleteButtons.size()) {
            // Klik na dugme za brisanje proizvoda na datom indeksu
            deleteButtons.get(index).click();
        } else {
            // Ako je indeks nevalidan, ispisuje poruku u konzoli
            System.out.println("Nevalidan indeks: " + index);
        }
    }


}
