package com.webshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clickLoginButton() {
        click(By.cssSelector("[class='button-1 login-button']"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
    }

    public void clickOnLoginLinkInHeader() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isProductAddedCorrect() {
        return isElementPresent(By.xpath("//*[.='14.1-inch Laptop']"));
    }

    public void addProductToTheCart() {
        click(By.cssSelector(".item-box:nth-child(3) .button-2.product-box-add-to-cart-button"));
    }

    public void clickOnShoppingCartButtonInHeader() {
        click(By.cssSelector("[href='/cart']"));
    }

    public void clickOnRegisterButton() {
        click(By.cssSelector("#register-button"));
    }

    public void fillInRegistrationForm(User user) {
        click(By.cssSelector(user.getGender()));
        type(By.cssSelector("#FirstName"), user.getName());
        type(By.cssSelector("#LastName"), user.getLastname());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getConfirmPassword());
    }

    public void clickOnRegisterButtonInHeader() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isUserExist() {
        if (driver.findElements(By.xpath("//li[contains(text(),'The specified email already exists')]")).size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isLogOutButtonExist() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }
}
