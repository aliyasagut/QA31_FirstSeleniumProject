package com.webshop.tests;

import com.webshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogOutButtonExist()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void createExistingAccountNegativeTest() {

        app.getUser().clickOnRegisterButtonInHeader();
        app.getUser().fillInRegistrationForm(new User()
                .setGender("#gender-female")
                .setName("testName")
                .setLastname("testLastName")
                .setEmail("test@ts.ts")
                .setPassword("test1234$")
                .setConfirmPassword("test1234$"));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isUserExist());
    }

    @Test(dataProvider = "createAccountWithCsv", dataProviderClass = DataProvider.class)
    public void createAccountsPositiveFromDataProviderWithFile(User user) {
        app.getUser().clickOnRegisterButtonInHeader();
        app.getUser().fillInRegistrationForm(user);
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutButtonExist());
    }
}
