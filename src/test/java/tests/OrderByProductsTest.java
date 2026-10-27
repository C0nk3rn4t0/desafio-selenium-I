package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderByProductsTest extends BaseTest {
    private static final String USER = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @Test
    public void sortProductsByPrice() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Titulo no encontrado");
        Assert.assertTrue(loginPage.loginButtonDisplayed(),"Boton de login no visible");
        Reporter.log("Página de login cargada correctamente", true);

        loginPage.login(USER,PASSWORD);

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Redireccion a la pagina de inventario fallida");
        Assert.assertTrue(inventoryPage.isTitleDisplayed(), "Titulo de la pagina de productos no es visible");
        Assert.assertEquals(inventoryPage.getTitle(), "Products", "El título no es 'Products'");
        Reporter.log("Título de productos visible", true);

        inventoryPage.sortBy("hilo");
        Reporter.log("Productos ordenados de mayor a menor", true);

        List<BigDecimal> itemPrices = inventoryPage.getItemPrices();
        Reporter.log("Precios: " + itemPrices, true);

        List<BigDecimal> newOrderPrices = new ArrayList<>(itemPrices);
        newOrderPrices.sort(Comparator.reverseOrder());

        Assert.assertEquals(itemPrices, newOrderPrices, "Los productos no están ordenados de mayor a menor");
        Reporter.log("Orden por precio correctamente", true);
        Assert.assertTrue(inventoryPage.getFirstItemPrice().compareTo(inventoryPage.getLastItemPrice()) > 0, "El primer precio no es mayor que el último");
        Reporter.log("El precio " + inventoryPage.getFirstItemPrice() + " es mayor que " + inventoryPage.getLastItemPrice(), true);
    }
}
