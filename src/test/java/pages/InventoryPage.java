package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;

    private static final String ADD_TO_CART = "add-to-cart-";

    private final By title = By.className("title");
    private final By dropDownProductSort = By.className("product_sort_container");
    private final By shoppingCart = By.className("shopping_cart_link");



    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addItemToShoppingCart(String product){
         By addItem = By.id(ADD_TO_CART + product);
         driver.findElement(addItem).click();
    }

    public void sortBy(String value){
        Select dropDown = new Select(driver.findElement(dropDownProductSort));
        dropDown.selectByValue(value);
    }

    public String getShoppingCartCount() {
        return driver.findElement(shoppingCart).getText();
    }

    public boolean isTitleDisplayed(){
        return driver.findElement(title).isDisplayed();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void goToCart(){
        driver.findElement(shoppingCart).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBe(title, "Your Cart"));
    }
}
