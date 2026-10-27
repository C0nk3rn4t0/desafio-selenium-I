package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private final WebDriver driver;

    private final By checkoutButton = By.id("checkout");
    private final By inventoryItemName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCheckout(){
        driver.findElement(checkoutButton).click();
    }

    public List<String> getItemNames() {
        List<WebElement> elements = driver.findElements(inventoryItemName);
        List<String> names = new ArrayList<>();

        for (WebElement element : elements) {
            names.add(element.getText());
        }

        return names;
    }
}
