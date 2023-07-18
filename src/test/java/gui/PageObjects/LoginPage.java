package gui.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class LoginPage {
    @FindBy(id = "email")
    private WebElement eMailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "btnSubmit")
    private WebElement submitButton;

    private final WebDriver driver;

    public LoginPage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void insertEmailAddress(String eMail) {
        eMailField.sendKeys(eMail);
    }
    public void insertPassword(String password) {
        eMailField.sendKeys(password);
    }

    public void clickLogin() {
        submitButton.click();
    }

    public void loadLoginPage() {
        driver.get("https://practicesoftwaretesting.com/#/auth/login");
    }

}
