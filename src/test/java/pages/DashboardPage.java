package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    By pimMenu = By.xpath("//span[text()='PIM']");
    By userDropdown = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p");
    By logoutBtn = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToPIMModule() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pimMenu)).click();
    }
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn)).click();
    }
}
