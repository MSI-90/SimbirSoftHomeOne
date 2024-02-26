package tests.UserIsSet;

import Helpers.BankManage.DataClassForManagerPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class UserIsSetTest extends BaseTest {

    @Test
    public void openBankPageAndCreateUser(){
        basePage
                .open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        bankCreatePage
                .addCustomerButtonClick()
                .enterFirstName()
                .enterLastName()
                .enterPostCode()
                .submitButtonClick();

        dataFormanager
                .allertIsVisible();

        customerPage
                .openCustomers()
                .insertUserNameAsTextIntoInput();
    }

    @Test
    public void sortCustomersByFirstName(){
        basePage
                .open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        customerPage
                .openCustomers()
                .getAllCeills();

    }

    @Test
    public void deleteUserFromTable(){
        basePage
                .open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        customerPage
                .openCustomers()
                .getAllCeills()
                .deleteUserFromTable();
    }
}
