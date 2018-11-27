package testOmanAir;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.HomePage;

public class OmanAir {
    WebDriver driver;
    HomePage homePage;
    @BeforeSuite
    public void start(){
        System.setProperty("webdriver.chrome.driver","source\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.navigate().to("https://www.omanair.com/");
    }
    @Test
    public void tryToSearchWithoutReturnDate(){
        Assert.assertEquals(homePage.tryToSearchWithoutReturnDate(),"Please select a return date");
    }
    @AfterSuite
    public void finish(){
        driver.close();
    }
}
