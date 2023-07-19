import gui.PageObjects.LoginPage;
import gui.Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginSuccess() {
        loginPage.insertEmailAddress("user@example.com");
        loginPage.insertPassword("password123");
        loginPage.clickLogin();
        // Assuming the success login takes the user to another page, you can add verification logic here.
        // For example, you can check if a certain element exists on the next page to verify the successful login.
    }

    @Test
    public void testLoginFailure() {
        loginPage.insertEmailAddress("invaliduser@example.com");
        loginPage.insertPassword("wrongpassword");
        loginPage.clickLogin();
        // Assuming the login failure displays an error message, you can add verification logic here.
        // For example, you can check if an error message element exists on the login page to verify the login failure.
    }

    @Test
    public void testEmptyFields() {
        loginPage.clickLogin();
        // Assuming the login attempt does not proceed with empty fields and displays an error message, you can add verification logic here.
        // For example, you can check if an error message element exists on the login page to verify the empty fields error.
    }
}
