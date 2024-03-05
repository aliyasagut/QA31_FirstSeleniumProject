package com.webshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductHelper extends BaseHelper{

    public ProductHelper(WebDriver driver) {
        super(driver);
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
}
