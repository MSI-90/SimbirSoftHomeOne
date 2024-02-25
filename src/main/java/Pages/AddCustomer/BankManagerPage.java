package Pages.AddCustomer;

import Pages.Base.BasePage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static Pages.AddCustomer.BankManagerData.*;

public class BankManagerPage extends BasePage {
    public BankManagerPage(WebDriver driver) {
        super(driver);
    }

    By addCustomer = By.xpath("//div[@class='ng-scope']//div[@class='center']//button[@class='btn btn-lg tab']");
    By firstNameInput = By.xpath("//div[@class='ng-scope']//form[@name='myForm']//div[@class='form-group'][1]//input");
    By lastNameInput = By.xpath("//div[@class='ng-scope']//form[@name='myForm']//div[@class='form-group'][2]//input");
    By postalCode = By.xpath("//div[@class='ng-scope']//form[@name='myForm']//div[@class='form-group'][3]//input");
    By submitButton = By.xpath("//form[@name='myForm']//button[@type='submit']");

    public String[] getSimbol(long digit){
        String numberString = Long.toString(digit);
        int arrayLength = (int) Math.ceil((double) numberString.length() / 2);
        String[] array = new String[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = numberString.substring(i * 2, i * 2 + 2);
        }
        return array;
    }

    public String getStringFromDigit(){
        String[] str = getSimbol(numberDigits);
        String arrayToString = "";

        for(String s : str)
            arrayToString += s;

        return arrayToString;
    }

    public String getString(String[] stringsArrFromLongDigit, String[] englishLetters, long digit){
        String str = "";
        int numberOfSimbols = 25;
        int numberFromConvert = 0;
        int postFromPercent = 0;
        for (int i = 0; i < stringsArrFromLongDigit.length; i++){
            numberFromConvert = Integer.parseInt(stringsArrFromLongDigit[i]);
            if (numberFromConvert > numberOfSimbols){
                postFromPercent = numberFromConvert % numberOfSimbols;
                str += englishLetters[postFromPercent];
            }
            else{
                str += englishLetters[numberFromConvert];
            }
        }
        return str;
    }

    public BankManagerPage addCustomerButtonClick(){
        driver.findElement(addCustomer).click();
        return this;
    }

    public BankManagerPage enterFirstName(){
        WebElement element = driver.findElement(firstNameInput);
        element.click();
        String[] strFromDigit = getSimbol(numberDigits);
        String textForFirstname = getString(strFromDigit, englishLetters, numberDigits);
        element.sendKeys(textForFirstname);
        regData.put("firstName", textForFirstname);
        return this;
    }

    public BankManagerPage enterLastName(){
        WebElement element = driver.findElement(lastNameInput);
        element.click();
        String lastName = "Dementorovich";
        element.sendKeys(lastName);
        regData.put("lastName", lastName);
        return this;
    }

    public BankManagerPage enterPostCode(){
        WebElement element = driver.findElement(postalCode);
        element.click();
        String postCode = getStringFromDigit();
        element.sendKeys(postCode);
        regData.put("postCode", postCode);
        return this;
    }

    public BankManagerPage submitButtonClick(){
        driver.findElement(submitButton).click();
        return this;
    }

    public BankManagerPage allertIsVisible(){
        SoftAssert softAssert = new SoftAssert();
        String textFromAlert = "";
        try{
            Alert alert = driver.switchTo().alert();
            textFromAlert = alert.getText();
            alert.accept();
        }catch (Exception ex){
            softAssert.fail("Информация из формы не отправлена!");
        }

        return  this;
    }
}
