package Pages.Customers;

import Helpers.CustomerPage.DataClassFroCustomerPage;
import Pages.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.*;

import static Helpers.BankManage.DataClassForManagerPage.*;
import static Helpers.CustomerPage.DataClassFroCustomerPage.*;

public class CustomersPage extends BasePage {
    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    private By customersButton = By.xpath("//button[@ng-class='btnClass3']");
    private By searchCustomerInput = By.xpath("//div[@class='input-group']//input[@type='text']");
    private By firstnameLink = By.xpath("//table//thead//tr//td[1]//a");
    private By getInfoFromTable = By.xpath("//table//tbody//td");
    private By allRoutesFromTable = By.xpath("//table//tbody//tr");

    public CustomersPage openCustomers(){
        driver.findElement(customersButton).click();
        return this;
    } //открыть страницу

    /*
    public WebElement insertUserNameAsTextIntoInput(String username){
        if (username != null)
        {
            WebElement element = driver.findElement(searchCustomerInput);
            element.click();
            element.sendKeys(username);

            WebElement elementName = driver.findElements(getInfoFromTable).get(0);

            return elementName;
        }

        return null;
    }
    */

    public List<WebElement> insertUserNameAsTextIntoInput(String username){
        List<WebElement> elements = new ArrayList<>();
        if (username != null)
        {
            WebElement element = driver.findElement(searchCustomerInput);
            element.click();
            element.sendKeys(username);

            elements = driver.findElements(getInfoFromTable);
        }

        return elements;
    }

    public CustomersPage getAllCeills(){
        List<WebElement> elements = driver.findElements(allRoutesFromTable);
        int indexOfEmptySymbol = 0;

        if(elements.size() > 0){
            firstnames.clear();
            for (WebElement element : elements){
                indexOfEmptySymbol = element.getText().indexOf(" ");
                firstnames.add((element.getText()).substring(0, indexOfEmptySymbol));
            }
        }

        return this;
    }

    public ArrayList<String> getSortCeills(boolean sortAscending){

        firstNamesAfterSort.clear();
        int indexOfEmptySymbol = 0;

        if (!sortAscending){
            WebElement firstNameLink = driver.findElement(firstnameLink);
            firstNameLink.click();
            List<WebElement> elements = driver.findElements(allRoutesFromTable);
            if(elements.size() > 0){

                for (WebElement element : elements){
                    indexOfEmptySymbol = element.getText().indexOf(" ");
                    firstNamesAfterSort.add((element.getText()).substring(0, indexOfEmptySymbol));
                }
            }
        }

        if (sortAscending){
            WebElement firstNameLink = driver.findElement(firstnameLink);
            firstNameLink.click();
            firstNameLink.click();
            List<WebElement> elements = driver.findElements(allRoutesFromTable);
            if(elements.size() > 0){

                for (WebElement element : elements){
                    indexOfEmptySymbol = element.getText().indexOf(" ");
                    firstNamesAfterSort.add((element.getText()).substring(0, indexOfEmptySymbol));
                }
            }
        }

        return firstNamesAfterSort;
    }

    public ArrayList<String> sortInListOfNames(boolean sortAscending){
        ArrayList<String> sortedNames = new ArrayList<>(firstnames);

        if (sortAscending) {
            Collections.sort(sortedNames, String.CASE_INSENSITIVE_ORDER);
        } else {
            Collections.sort(sortedNames, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        }
        return sortedNames;
    }

    public CustomersPage deleteUserFromTable(int userId){
        By buttonIdForDelete = By.xpath("//table//tbody//tr["+userId+"]//button");
        List<WebElement> elements = driver.findElements(buttonIdForDelete);

        if (elements.size() == 0){
            Assert.fail("Нет элементов для удаления");
        }
        else{
            elements.get(0).click();
        }
        return this;
    }

}
