package Pages.AddCustomer;

import Helpers.BankManage.DataClassForManagerPage;
import Pages.Base.BasePage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class BankManagerPage extends BasePage {
    public BankManagerPage(WebDriver driver) {
        super(driver);
    }

    private By addCustomer = By.xpath("//div[@class='ng-scope']//div[@class='center']//button[@class='btn btn-lg tab']");
    private By firstNameInput = By.xpath("//div[@class='ng-scope']//form[@name='myForm']//div[@class='form-group'][1]//input");
    private By lastNameInput = By.xpath("//div[@class='ng-scope']//form[@name='myForm']//div[@class='form-group'][2]//input");
    private By postalCode = By.xpath("//div[@class='ng-scope']//form[@name='myForm']//div[@class='form-group'][3]//input");
    private By submitButton = By.xpath("//form[@name='myForm']//button[@type='submit']");

    public BankManagerPage addCustomerButtonClick(){
        driver.findElement(addCustomer).click();
        return this;
    }

    public BankManagerPage enterFirstName(){
        WebElement element = driver.findElement(firstNameInput);
        element.click();
        String[] strFromDigit = DataClassForManagerPage.digitAsString;
        String textForFirstname = DataClassForManagerPage.getString;
        element.sendKeys(textForFirstname);
        DataClassForManagerPage.regData.put("firstName", textForFirstname);
        return this;
    }

    public BankManagerPage enterLastName(){
        WebElement element = driver.findElement(lastNameInput);
        element.click();
        String lastName = "Dementorovich";
        element.sendKeys(lastName);
        DataClassForManagerPage.regData.put("lastName", lastName);
        return this;
    }

    public BankManagerPage enterPostCode(){
        WebElement element = driver.findElement(postalCode);
        element.click();
        String postCode = DataClassForManagerPage.getStringFromDigit;
        element.sendKeys(postCode);
        DataClassForManagerPage.regData.put("postCode", postCode);
        return this;
    }

    public BankManagerPage submitButtonClick(){
        driver.findElement(submitButton).click();
        return this;
    }
}
