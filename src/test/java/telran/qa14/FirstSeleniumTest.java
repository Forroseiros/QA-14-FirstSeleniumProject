package telran.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest {
    WebDriver driver;

    // before - setUp(){}
    @BeforeMethod
    public void setUP(){
        // System.setProperty("webdriver.chrome.driver","C:/tools/chromedriver/chromedriver.exe");

        // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    // Test
    @Test
    public void searchProductTest(){
        driver.findElement(By.name("search_query")).sendKeys("summer dresses" + Keys.ENTER);
        String text = driver.findElement(By.className("lighter")).getText();
        Assert.assertEquals(text,"\"SUMMER DRESSES\"");


    }
    @Test
    public void searchTshirtProductTest(){
        driver.findElement(By.name("search_query")).sendKeys("t-shirt" + Keys.ENTER);
        String text = driver.findElement(By.className("lighter")).getText();
        Assert.assertEquals(text,"\"T-SHIRT\"");
    }

    // after - tearDown(){}
    @AfterMethod(enabled = false)
    public  void tearDown(){
        driver.quit();
    }

}
