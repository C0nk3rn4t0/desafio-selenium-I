package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector(".error-message-container.error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password){
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean loginButtonDisplayed(){
        return driver.findElement(loginButton).isDisplayed();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
