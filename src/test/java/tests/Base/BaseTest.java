package tests.Base;

import Common.CommonAction;
import Pages.AddCustomer.BankManagerPage;
import Pages.Base.BasePage;
import Pages.Customers.CustomersPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected BankManagerPage bankCreatePage = new BankManagerPage(driver);
    protected CustomersPage customerPage = new CustomersPage(driver);

    @AfterSuite(alwaysRun = true)
    public void quit(){
        driver.quit();
    }
}
