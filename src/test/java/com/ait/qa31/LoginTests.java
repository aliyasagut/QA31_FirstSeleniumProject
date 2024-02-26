package com.ait.qa31;

import com.webshop.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        // click on login
        click(By.cssSelector("[href='/login']"));
        // enter email
        type(By.cssSelector("#Email"), "test@ts.ts");
        // enter password
        type(By.cssSelector("#Password"), "test1234$");
        // click [login] button
        click(By.cssSelector("[class='button-1 login-button']"));
        // assert
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }
}
