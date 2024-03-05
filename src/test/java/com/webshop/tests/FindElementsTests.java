package com.webshop.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindElementsTests extends TestBase {

    @Test
    public void findElementsByCssSelector() {

        // className = .className
        app.driver.findElement(By.cssSelector(".ico-register"));

        // id = #id
        app.driver.findElement(By.cssSelector("#small-searchterms"));

        // tag = h2
        app.driver.findElement(By.cssSelector("h2"));

        // any = [attr='param']
        app.driver.findElement(By.cssSelector("[href='/books']"));

    }

    @Test
    public void findElementsByXPath() {

        // class=//*[@class='class name']
        app.driver.findElement(By.xpath("//*[@class='top-menu-triangle']"));

        // id -> //tag[@id='city']
        app.driver.findElement(By.xpath("//*[@id='flyout-cart']"));

        // tag name = //tagName
        app.driver.findElement(By.xpath("//h2"));

        // any -> //*[@attr='par']
        app.driver.findElement(By.xpath("//*[@href='/gift-cards']"));

        //by text
//        app.driver.findElement(By.xpath("//*[.='Welcome to our store']"));
        app.driver.findElement(By.xpath("//*[contains(.,'Welcome to our')]"));

    }
}
