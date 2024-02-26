package com.webshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddElementToTheCartTests extends TestBase {

    // precondition
    @BeforeMethod
    public void precondition() {
        // click on login
        click(By.cssSelector("[href='/login']"));
        // enter email
        type(By.cssSelector("#Email"), "test@ts.ts");
        // enter password
        type(By.cssSelector("#Password"), "test1234$");
        // click [login] button
        click(By.cssSelector("[class='button-1 login-button']"));
    }

    @Test
    public void addElementToTheCartTest() {
        // go to homepage
        // add product to the cart
        click(By.cssSelector(".item-box:nth-child(3) .button-2.product-box-add-to-cart-button"));
        // go to te cart
        click(By.cssSelector("[href='/cart']"));
        // assert product is added
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='14.1-inch Laptop']")));
    }

}
