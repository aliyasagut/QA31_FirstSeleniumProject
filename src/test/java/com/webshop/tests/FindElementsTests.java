package com.webshop.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindElementsTests extends TestBase{

    @Test
    public void findElementsByCssSelector() {

        // className = .className
        driver.findElement(By.cssSelector(".ico-register"));

        // id = #id
        driver.findElement(By.cssSelector("#small-searchterms"));

        // tag = h2
        driver.findElement(By.cssSelector("h2"));

        // any = [attr='param']
        driver.findElement(By.cssSelector("[href='/books']"));

    }

    @Test
    public void findElementsByXPath() {

        // class=//*[@class='class name']
        driver.findElement(By.xpath("//*[@class='top-menu-triangle']"));

        // id -> //tag[@id='city']
        driver.findElement(By.xpath("//*[@id='flyout-cart']"));

        // tag name = //tagName
        driver.findElement(By.xpath("//h2"));

        // any -> //*[@attr='par']
        driver.findElement(By.xpath("//*[@href='/gift-cards']"));

        //by text
        driver.findElement(By.xpath("//*[.='Welcome to our store']"));
        driver.findElement(By.xpath("//*[contains(.,'Welcome to our')]"));

    }
}
