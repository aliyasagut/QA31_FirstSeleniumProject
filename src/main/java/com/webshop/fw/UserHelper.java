package com.webshop.fw;

import com.webshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
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

    public void clickOnRegisterButton() {
        click(By.cssSelector("#register-button"));
    }

    public void fillInRegistrationForm(User user) {
//        click(By.cssSelector(user.getGender()));
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

    public void clickOnLogOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }
}
