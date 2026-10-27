package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginAndAddItemTest extends BaseTest {

    private static final String USER = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    //Script 1

    @Test
    public void addItemToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Titulo no encontrado");
        Assert.assertTrue(loginPage.loginButtonDisplayed(),"Boton de login no visible");
        Reporter.log("Página de login cargada correctamente", true);

        loginPage.login(USER,PASSWORD);

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Redireccion a la pagina de inventario fallida");
        Assert.assertTrue(inventoryPage.isTitleDisplayed(), "Titulo de la pagina de productos no es visible");
        Assert.assertEquals(inventoryPage.getTitle(), "Products", "El título no es 'Products'");
        Reporter.log("Título de productos visible", true);

        inventoryPage.addItemToShoppingCart("sauce-labs-backpack");

        Assert.assertFalse(inventoryPage.getShoppingCartCount().contains("empty"),"No se añadieron los productos" );
        Reporter.log("Producto añadido", true);

        inventoryPage.goToCart();

        Assert.assertTrue(cartPage.getItemNames().contains("Sauce Labs Backpack"),"Item no fue agregado");
        Reporter.log("Productos en el carrito" + cartPage.getItemNames(), true);
    }

}
