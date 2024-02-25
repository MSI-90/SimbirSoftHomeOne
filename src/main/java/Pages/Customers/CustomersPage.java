package Pages.Customers;

import Pages.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.*;

import static Pages.AddCustomer.BankManagerData.regData;

public class CustomersPage extends BasePage {
    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    TreeSet<String> firstnames = new TreeSet<String>();

    By customersButton = By.xpath("//button[@ng-class='btnClass3']");
    By searchCustomerInput = By.xpath("//div[@class='input-group']//input[@type='text']");
    By getInfoFromTable = By.xpath("//table//tbody//td");
    By allRoutesFromTable = By.xpath("//table//tbody//tr");

    public CustomersPage openCustomers(){
        driver.findElement(customersButton).click();
        return this;
    } //открыть страницу

    public CustomersPage insertUserNameAsTextIntoInput(){
        SoftAssert softAssert = new SoftAssert();
        WebElement element = driver.findElement(searchCustomerInput);
        element.click();
        element.sendKeys(regData.get("firstName"));

        List<WebElement> elements = driver.findElements(getInfoFromTable);

        softAssert.assertEquals(elements.get(0).getText(), regData.get("firstName"), isCompleate(elements.get(0).getText(), regData.get("firstName")));
        return this;
    }

    // получить список имен
    public CustomersPage getAllCeills(){
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> elements = driver.findElements(allRoutesFromTable);
        int indexOfEmptySymbol = 0;

        if(elements.size() > 0){
            for (WebElement element : elements){
                indexOfEmptySymbol = element.getText().indexOf(" ");
                firstnames.add((element.getText()).substring(0, indexOfEmptySymbol));
            }
        }

        if (firstnames.size() == 0)
            softAssert.fail("Список имен не получен");

        return this;
    }

    public CustomersPage sortInListOfNames(boolean sortAscending){
        if (sortAscending) {
            firstnames.forEach(System.out::println);
        } else {
            TreeSet<String> descSort = new TreeSet<String>(Comparator.reverseOrder());
            descSort.addAll(firstnames);
            descSort.forEach(System.out::println);
        }
        return this;
    }

    public int averageOfNames(){
        int itemsSumm = firstnames.stream()
                .mapToInt(String::length)
                .sum();
        int averageLength =  (int)Math.ceil((double) itemsSumm / firstnames.size());

        return averageLength;
    }

    public CustomersPage deleteUserFromTable(){
        SoftAssert softAssert = new SoftAssert();
        int userId = averageOfNames();

        By buttonIdForDelete = By.xpath("//table//tbody//tr["+userId+"]//button");
        List<WebElement> elements = driver.findElements(buttonIdForDelete);

        if (elements.size() == 0){
            softAssert.fail("Нет элементов для удаления");
        }
        else{
            elements.get(0).click();
        }

        return this;
    }

    protected String isCompleate(String firstNameFromTable, String fromRegData){
        String result = null;
        if (!firstNameFromTable.equals(fromRegData)){
            result = "Что-то не так, значение указаное пользователем при заполнении формы - " + fromRegData + " не пришло на сервер";
        }
        return result;
    }
}
