package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidedLoginTest extends BaseTest {
    private static final String USER = "locked_out_user";
    private static final String PASSWORD = "secret_sauce";

    @Test
    public void loginWithLockedUser() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Titulo no encontrado");
        Assert.assertTrue(loginPage.loginButtonDisplayed(),"Boton de login no visible");
        Reporter.log("Página de login cargada correctamente", true);

        loginPage.login(USER,PASSWORD);

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.","Mensaje de error de usuario bloqueado no desplagado");
        Reporter.log("Usuario Bloqueado, mensaje de error desplegado", true);

    }
}
