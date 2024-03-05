package com.webshop.tests;

import com.webshop.models.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @DataProvider
    public Iterator<Object[]> createAccountWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/accounts.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new User().setName(split[0])
                    .setLastname(split[1]).setEmail(split[2]).setPassword(split[3]).setConfirmPassword(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "createAccountWithCsv")
    public void createAccountsPositiveFromDataProviderWithFile(User user) {
        app.getUser().clickOnRegisterButtonInHeader();
        app.getUser().fillInRegistrationForm(user);
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogOutButtonExist());
    }
}
