package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepTwoPage {
    private final WebDriver driver;

    private final By title = By.className("title");
    private final By finishButton = By.id("finish");

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCheckoutComplete(){
        driver.findElement(finishButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBe(title, "Checkout: Complete!"));
    }
}
