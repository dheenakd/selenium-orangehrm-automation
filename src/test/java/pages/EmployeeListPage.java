package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeeListPage {
    WebDriver driver;
    WebDriverWait wait;

    By employeeListTab = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a");
    By nameSearchBox = By.xpath("//input[@placeholder='Type for hints...']");
    By searchBtn = By.xpath("//button[@type='submit']");
    By searchResult = By.xpath("//div[@class='oxd-table-body']//div[contains(text(),'John')]");
    By resetBtn = By.xpath("//button[@type='reset']");
    
    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToEmployeeList() {
        wait.until(ExpectedConditions.elementToBeClickable(employeeListTab)).click();
    }

    public boolean searchEmployeeByName(String name) throws InterruptedException {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(nameSearchBox));
        //nameField.clear(); 
        nameField.sendKeys(name);

        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(resetBtn)).click();
        

        try {
            // Dynamic XPath to check for name in results
            By dynamicResult = By.xpath("//div[@class='oxd-table-body']//div[contains(text(),'" + name + "')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(dynamicResult));
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
}
