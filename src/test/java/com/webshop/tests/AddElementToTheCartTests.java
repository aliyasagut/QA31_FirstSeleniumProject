package com.webshop.tests;

import com.webshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddElementToTheCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.getUser().clickOnLoginLinkInHeader();
        app.getUser().fillLoginForm(new User()
                .setEmail("test@ts.ts")
                .setPassword("test1234$"));
        app.getUser().clickLoginButton();
    }

    @Test
    public void addElementToTheCartTest() {
        app.getProduct().addProductToTheCart();
        app.getProduct().clickOnShoppingCartButtonInHeader();
        Assert.assertTrue(app.getProduct().isProductAddedCorrect());
    }
}
