package com.webshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

//    @Test
//    public void createNewAccountPositiveTest() {
//
//        // open register page
//        click(By.cssSelector("[href='/register']"));
//        // check radio
//        click(By.cssSelector("#gender-female"));
//        // enter name
//        type(By.cssSelector("#FirstName"), "testName");
//        // enter last name
//        type(By.cssSelector("#LastName"), "testLastName");
//        // enter email
//        type(By.cssSelector("#Email"), "test@ts.ts");
//        // enter password
//        type(By.cssSelector("#Password"), "test1234$");
//        // confirm password
//        type(By.cssSelector("#ConfirmPassword"), "test1234$");
//        // register button
//        click(By.cssSelector("#register-button"));
//        //assert
//        Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
//    }

    @Test
    public void createExistingAccountNegativeTest() {

        // open register page
        click(By.cssSelector("[href='/register']"));
        // check radio
        click(By.cssSelector("#gender-female"));
        // enter name
        type(By.cssSelector("#FirstName"), "testName");
        // enter last name
        type(By.cssSelector("#LastName"), "testLastName");
        // enter email
        type(By.cssSelector("#Email"), "test@ts.ts");
        // enter password
        type(By.cssSelector("#Password"), "test1234$");
        // confirm password
        type(By.cssSelector("#ConfirmPassword"), "test1234$");
        // register button
        click(By.cssSelector("#register-button"));
        //assert
        Assert.assertTrue(isUserExist());
    }

    public boolean isUserExist() {
        if (driver.findElements(By.xpath("//li[contains(text(),'The specified email already exists')]")).size() > 0) {
            return true;
        }
        return false;
    }


}
