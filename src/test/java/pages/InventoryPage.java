package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    private final WebDriver driver;

    private static final String ADD_TO_CART = "add-to-cart-";

    private final By title = By.className("title");
    private final By dropDownProductSort = By.className("product_sort_container");
    private final By shoppingCart = By.className("shopping_cart_link");
    private final By inventoryItemPrice = By.className("inventory_item_price");



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

    public List<BigDecimal> getItemPrices() {
        List<WebElement> elements = driver.findElements(inventoryItemPrice);
        List<BigDecimal> prices = new ArrayList<>();

        for (WebElement element : elements) {
            String text = element.getText().replace("$", "");
            prices.add(new BigDecimal(text));
        }

        return prices;
    }

    public BigDecimal getFirstItemPrice() {
        return getItemPrices().get(0);
    }

    public BigDecimal getLastItemPrice() {
        List<BigDecimal> prices = getItemPrices();
        return prices.get(prices.size() - 1);
    }

}
