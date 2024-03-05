package com.webshop.tests;

import com.webshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLinkInHeader();
        app.getUser().fillLoginForm(new User()
                .setEmail("test@ts.ts")
                .setPassword("test1234$"));
        app.getUser().clickLoginButton();
        Assert.assertTrue(app.getUser().isLogOutButtonExist());
    }
}
