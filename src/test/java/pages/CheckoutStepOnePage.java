package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepOnePage {
    private final WebDriver driver;

    private final By title = By.className("title");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
    }

    public void userInformation(String name, String surname, String postalNumber){
        driver.findElement(firstName).sendKeys(name);
        driver.findElement(lastName).sendKeys(surname);
        driver.findElement(postalCode).sendKeys(postalNumber);
    }

    public void goToCheckoutStepTwo(){
        driver.findElement(continueButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBe(title, "Checkout: Overview"));
    }

}
