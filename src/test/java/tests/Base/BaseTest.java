package tests.Base;

import Common.CommonAction;
import Helpers.BankManage.DataClassForManagerPage;
import Helpers.OutsidersClasses.Outsider;
import Pages.AddCustomer.BankManagerPage;
import Pages.Base.BasePage;
import Pages.Customers.CustomersPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected BankManagerPage bankCreatePage = new BankManagerPage(driver);
    protected CustomersPage customerPage = new CustomersPage(driver);
    protected Outsider outsider = new Outsider(driver);

    @AfterSuite(alwaysRun = true)
    public void quit(){
        driver.quit();
    }
}
