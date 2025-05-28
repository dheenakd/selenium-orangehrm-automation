package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.BaseTest;

public class TestRunner extends BaseTest{
	
	@Test
	public void test() throws InterruptedException {
	LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        Thread.sleep(3000);

        DashboardPage dashboardPage = new DashboardPage(driver);
     
        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
       
        String[][] employeeData = {
            {"Dheena", "K"},
            {"Abishek", "A"},
            {"Akash", "N"}
        };

        for (String[] emp : employeeData) {
            String firstName = emp[0];
            String lastName = emp[1];
            dashboardPage.goToPIMModule();
            addEmployeePage.goToAddEmployeePage();
            addEmployeePage.addEmployee(firstName, lastName);
            Thread.sleep(3000);
            dashboardPage.goToPIMModule();
            
        }
        
        EmployeeListPage employeeListPage = new EmployeeListPage(driver);
        employeeListPage.goToEmployeeList();

        // List of employee first names to check
        String[] employeeFirstNames = { "Dheena", "Abishek", "Akash"};

        for (String name : employeeFirstNames) {
            boolean found = employeeListPage.searchEmployeeByName(name);
            Assert.assertTrue(found, "Employee '" + name + "' not found in the list");
            System.out.println("Employee '" + name + "' was successfully found in the list");
        }
	dashboardPage.logout();
    }

}
