package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class testBase {
    public static WebDriver driver;
//
//    @BeforeClass()
//    public void setUp()
//    {
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.get("https://demo.nopcommerce.com/");
//    }

    @AfterClass
    public void tearDown()
    {
        if (driver != null) {
            driver.quit();}
    }

    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }




}
