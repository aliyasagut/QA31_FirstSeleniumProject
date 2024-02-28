package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        clickOnLoginLinkInHeader();
        fillLoginForm(new User()
                .setEmail("test@ts.ts")
                .setPassword("test1234$"));
        clickLoginButton();
        Assert.assertTrue(isLogOutButtonExist());
    }
}
