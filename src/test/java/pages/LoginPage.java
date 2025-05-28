package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By username = By.xpath("//input[@name='username']");
    By password = By.xpath("//input[@name='password']");
    By loginBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String user, String pass) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));

        userField.clear();
        userField.sendKeys(user);

        passField.clear();
        passField.sendKeys(pass);

        loginButton.click();
    }
}
