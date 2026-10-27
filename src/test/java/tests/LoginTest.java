package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private static final String USER = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @Test
    public void loginWithUserAndPassword() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertTrue(loginPage.loginButtonDisplayed(),"Pagina de login correcta");

        loginPage.login(USER,PASSWORD);

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Redireccion a la pagina de inventario");
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed(), "Titulo de la pagina de productos visible");


    }
}
