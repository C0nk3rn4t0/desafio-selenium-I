package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void pageLoadsSuccessfully() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
    }
}