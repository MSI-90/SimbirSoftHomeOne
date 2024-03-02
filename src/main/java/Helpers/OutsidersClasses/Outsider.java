package Helpers.OutsidersClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Outsider {
    protected WebDriver driver;

    public Outsider(WebDriver driver){
        this.driver = driver;
    }

    public void allertIsVisible(){
        SoftAssert softAssert = new SoftAssert();
        String textFromAlert = "";
        try{
            Alert alert = driver.switchTo().alert();
            textFromAlert = alert.getText();
            alert.accept();
        }catch (Exception ex){
            softAssert.fail("Информация из формы не отправлена!");
        }
    }
}
