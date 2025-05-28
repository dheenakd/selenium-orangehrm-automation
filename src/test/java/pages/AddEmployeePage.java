package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage {
    WebDriver driver;
    WebDriverWait wait;

    By addEmployeeTab = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    By firstName = By.xpath("//input[@name='firstName']");
    By lastName = By.xpath("//input[@name='lastName']");
    By saveBtn = By.xpath("//button[@type='submit']");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToAddEmployeePage() {
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeTab)).click();
    }

    public void addEmployee(String fName, String lName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lName);
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }
}

