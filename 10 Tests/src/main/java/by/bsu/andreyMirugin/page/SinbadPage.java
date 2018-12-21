package by.bsu.andreyMirugin.page;

import by.bsu.andreyMirugin.elems.SinbadElems;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SinbadPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private SinbadElems sinbadElems;


    public SinbadPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver,60);
        this.sinbadElems = new SinbadElems(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnSubmit(){
        sinbadElems.getSubmitButton().click();
    }

    public void clickOnTitle(int number){
        WebElement button = driver.findElement(By.xpath("//span[@id='titleSelectBoxIt']"));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        if (number>=0){
            for(int i=0;i<number;i++){
                button.sendKeys(Keys.ARROW_DOWN);
            }
        }
        else{
            for(int i=number;i!=0;i++){
                button.sendKeys(Keys.ARROW_UP);
            }
        }
        button.sendKeys(Keys.ENTER);
    }

    public void clickOnGender(int number){
        WebElement button = driver.findElement(By.xpath("//span[@id='genboxSelectBoxIt']"));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        if (number>=0){
            for(int i=0;i<number;i++){
                button.sendKeys(Keys.ARROW_DOWN);
            }
        }
        else{
            for(int i=number;i!=0;i++){
                button.sendKeys(Keys.ARROW_UP);
            }
        }
        button.sendKeys(Keys.ENTER);

    }

    public void fillFirstName(String name){
        sinbadElems.getInputFirstName().click();
        sinbadElems.getInputFirstName().sendKeys(name);
    }

    public void fillLastName(String name){
        sinbadElems.getInputLastName().click();
        sinbadElems.getInputLastName().sendKeys(name);
    }

}
