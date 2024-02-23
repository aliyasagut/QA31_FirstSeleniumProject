package com.ait.qa31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    //before - setUp, init
    @BeforeMethod
    public void setUo() {
        driver = new ChromeDriver();
//        driver.get("https://www.google.com/"); //new browser
        driver.navigate().to("https://www.google.com/"); //with history
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }

    //tests
    @Test
    public void openGoogleTest() {
        System.out.println("Google opened!");
    }

    //after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown() {
//        driver.quit(); // close all tabs and browser
        driver.close(); // close one last tab(if one tab -> close browser)
    }
}
