package tests.UserIsSet;

import Helpers.BankManage.DataClassForManagerPage;
import Helpers.CustomerPage.DataClassFroCustomerPage;
import Helpers.OutsidersClasses.Outsider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

import static Helpers.BankManage.DataClassForManagerPage.*;

public class UserIsSetTest extends BaseTest {

    @Test
    public void openBankPageAndCreateUser(){

        String firstname = DataClassForManagerPage.getString;
        String lastName = "Dementorovich";
        String postCode = DataClassForManagerPage.getStringFromDigit;
        String userName = (String) regData.get("firstName");

        basePage
                .open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        bankCreatePage
                .addCustomerButtonClick()
                .enterFirstName(firstname)
                .enterLastName(lastName)
                .enterPostCode(postCode)
                .submitButtonClick();

        outsider
                .allertIsVisible();

        customerPage
                .openCustomers();

        var elementFromCustomers = customerPage.insertUserNameAsTextIntoInput(userName);
        if (!elementFromCustomers.isEmpty()) {
            Assert.assertEquals(elementFromCustomers.get(0).getText(), userName,
                    DataClassFroCustomerPage.isCompleate(elementFromCustomers.get(0).getText(), userName));
        }
    }

    @Test
    public void sortCustomersByFirstName(){
        basePage
                .open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        customerPage
                .openCustomers()
                .getAllCeills();

        var firstNamesSortedOnSitepageVozrast = customerPage.getSortCeills(false);
        var firstNamesSortedInMethodVozrast = customerPage.sortInListOfNames(false);
        Assert.assertEquals(firstNamesSortedOnSitepageVozrast, firstNamesSortedInMethodVozrast,
                "Данные не были отсортированы");

        basePage
                .open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        customerPage
                .openCustomers()
                .getAllCeills();

        var firstNamesSortedOnSitepageUbiv = customerPage.getSortCeills(true);
        var firstNamesSortedInMethodUbiv = customerPage.sortInListOfNames(true);
        Assert.assertEquals(firstNamesSortedOnSitepageUbiv, firstNamesSortedInMethodUbiv,
                "Данные не были отсортированы");

    }

    @Test
    public void deleteUserFromTable(){
        basePage
                .open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        customerPage
                .openCustomers()
                .getAllCeills();

        int userId = DataClassFroCustomerPage.averageOfNames();

        customerPage
                .deleteUserFromTable(userId);

        String userInListById = DataClassFroCustomerPage.firstnames.get(userId-1);
        var elementFromCustomers = customerPage.insertUserNameAsTextIntoInput(userInListById);
        if (elementFromCustomers.isEmpty()) {
            Assert.assertTrue( true);
        }
        else{
            Assert.fail("Пользователь с индексом " + userId + " не был удалён из таблицы");
        }

    }
}
