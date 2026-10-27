package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.*;

public class PurchaseTest extends BaseTest {
    private static final String USER = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String NAME = "Nombre";
    private static final String SURNAME = "Apellido";
    private static final String POSTALCODE = "210000";
    private static final String ITEM = "sauce-labs-backpack";
    private static final String ITEM_NAME = "Sauce Labs Backpack";
    private static final String COMPLETE_MESSAGE = "Thank you for your order!";

    //Script 4

    @Test
    public void completePurchaseTest() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Titulo no encontrado");
        Assert.assertTrue(loginPage.loginButtonDisplayed(),"Boton de login no visible");
        Reporter.log("Página de login cargada correctamente", true);

        loginPage.login(USER,PASSWORD);

        Assert.assertEquals(inventoryPage.getTitle(), "Products", "El título no es 'Products'");
        Reporter.log("Título de productos visible", true);

        inventoryPage.addItemToShoppingCart(ITEM);

        Assert.assertFalse(inventoryPage.getShoppingCartCount().contains("empty"),"No se añadieron los productos" );
        Reporter.log("Producto añadido", true);

        inventoryPage.goToCart();

        Assert.assertTrue(cartPage.getItemNames().contains(ITEM_NAME ),"Item no fue agregado");
        Reporter.log("Productos en el carrito" + cartPage.getItemNames(), true);

        cartPage.goToCheckout();
        Reporter.log("Redireccion al formulario de checkout", true);

        checkoutStepOnePage.userInformation(NAME,SURNAME,POSTALCODE);
        Reporter.log("Datos: " + NAME + " " + SURNAME + ", " + POSTALCODE, true);

        checkoutStepOnePage.goToCheckoutStepTwo();
        Reporter.log("Redireccion al resumen", true);


        checkoutStepTwoPage.goToCheckoutComplete();
        Assert.assertEquals(checkoutCompletePage.getCompleteMessage(), COMPLETE_MESSAGE, "No aparece mensaje de confirmacion");
        Reporter.log("Compra completada: " + checkoutCompletePage.getCompleteMessage(), true);
    }
}
