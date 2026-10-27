package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private final WebDriver driver;

    private final By checkoutButton = By.id("checkout");
    private final By inventoryItemName = By.className("inventory_item_name");
    private final By title = By.className("title");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getItemNames() {
        List<WebElement> elements = driver.findElements(inventoryItemName);
        List<String> names = new ArrayList<>();

        for (WebElement element : elements) {
            names.add(element.getText());
        }

        return names;
    }

    public void goToCheckout(){
        driver.findElement(checkoutButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBe(title, "Checkout: Your Information"));
    }
}
