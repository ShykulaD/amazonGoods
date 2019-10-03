package Actions;

import Utilities.Exceldata;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by ShykulaD on 03/10/2019.
 */
public class Singin extends Exceldata {
    WebDriver driver;
    String baseUrl = "https://www.6pm.com/login";
    Map<String, Object[]> testresultdata;

    @Test(dataProvider = "TestData")
    public void Customer_Signin(String Username, String Password, String Test_Results) {

        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("ap_email")).sendKeys(Username);
        driver.findElement(By.id("ap_password")).sendKeys(Password);
        driver.findElement(By.id("signInSubmit")).click();

        String actual = driver.getTitle();
        String Expected = "Discount Shoes, Clothing & Accessories | 6pm";
        try {
            Assert.assertEquals(actual, Expected);
            System.out.println("Login Test Case is Pass");
            driver.quit();
        } catch (Exception e) {
            System.out.println("Login Test Case is Fail");
            driver.quit();

        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
