package com.webshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductHelper extends BaseHelper{

    public ProductHelper(WebDriver driver) {
        super(driver);
    }

//    Все хорошо, но для Assert следовало выбрать метод, проверяющий текст в элементе
    public boolean isProductAddedCorrect() {
//        return isElementPresent(By.xpath("//*[.='14.1-inch Laptop']"));
        String actual = driver.findElement(By.cssSelector(".product-name")).getText();
        String expected = "14.1-inch Laptop";
        return actual.equals(expected);
    }

    public void addProductToTheCart() {
        click(By.cssSelector(".item-box:nth-child(3) .button-2.product-box-add-to-cart-button"));
    }

    public void clickOnShoppingCartButtonInHeader() {
        click(By.cssSelector("[href='/cart']"));
    }
}
