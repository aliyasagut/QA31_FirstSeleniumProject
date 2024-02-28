package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddElementToTheCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLinkInHeader();
        fillLoginForm(new User()
                .setEmail("test@ts.ts")
                .setPassword("test1234$"));
        clickLoginButton();
    }

    @Test
    public void addElementToTheCartTest() {
        addProductToTheCart();
        clickOnShoppingCartButtonInHeader();
        Assert.assertTrue(isProductAddedCorrect());
    }
}
