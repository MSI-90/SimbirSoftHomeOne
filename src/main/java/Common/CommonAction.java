package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static Common.Config.PLATFORM_AND_BROWSER;
import static Common.Config.IMPLICIT_WAIT;

public class CommonAction {
    private static WebDriver driver = null;

    private CommonAction(){
    }

    public static WebDriver createDriver(){
        SoftAssert softAssert = new SoftAssert();
        if (driver == null){
            switch (PLATFORM_AND_BROWSER){
                case "win_chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    driverConfigs(driver);
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--headless");
                    break;
                default:
                    softAssert.fail("incorrect platform or browser name " + PLATFORM_AND_BROWSER);
            }
        }
        return driver;
    }

    private static void driverConfigs(WebDriver driver){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
}
