package testingOmanAir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OmanAir {
    WebDriver driver;
    @BeforeSuite
    public void start(){
        System.setProperty("webdriver.chrome.driver","driver\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions co=new ChromeOptions();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.omanair.com/");
    }
    @Test
    public void sendingEmptyDestinationFieldTest(){
            driver.findElement(By.xpath("//div[@class=\"booking-button bfFlightSearchSubmitHomebtn\"]/button")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class=\"errorDiv\"]/p"));
        Assert.assertEquals(errorMessage.getText(),"Please select To station");
    }
    @AfterSuite
    public void finish(){
        driver.close();
    }


}
