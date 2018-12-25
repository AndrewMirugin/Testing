package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

}
