package gui.Tests;

import gui.PageObjects.LoginPage;
import gui.Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;

    @Test
    public void testLoginSuccess() {
        loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        loginPage.insertEmailAddress("user@example.com");
        loginPage.insertPassword("password123");
        loginPage.clickLogin();
        // Assuming the success login takes the user to another page, you can add verification logic here.
        // For example, you can check if a certain element exists on the next page to verify the successful login.
    }

    @Test
    public void testLoginFailure() {
        loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        loginPage.insertEmailAddress("invaliduser@example.com");
        loginPage.insertPassword("wrongpassword");
        loginPage.clickLogin();

        Assert.assertEquals(loginPage.getErrorMessageLogin(), "Invalid email or password");
    }

    @Test
    public void testEmptyFields() {
        loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        loginPage.clickLogin();
        
        Assert.assertEquals(loginPage.getErrorMessageEMail(), "E-mail is required.");
    }

    @Test
    public void testEmptyPasswordField() {
        loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        loginPage.insertEmailAddress("test@test.at");
        loginPage.clickLogin();
  
        Assert.assertEquals(loginPage.getErrorMessagePassword(), "Password is required.");
    }
}
