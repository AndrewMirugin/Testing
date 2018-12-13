package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class SinbadPage {

    @FindBy(xpath = "//span[@id='titleSelectBoxIt']/span")
    private WebElement openTitleSpisButton;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@id='datepicker']")
    private WebElement inputDate;

    @FindBy(xpath = "//input[@id='submitBtn']")
    private WebElement submitButton;

    @FindBy(xpath = "//label[@id='errorMessage']")
    private WebElement errorMessage;

    @FindBy(xpath = "//ul[@id='genboxSelectBoxItOptions']/li")
    private List<WebElement> genderSpis;

    @FindBy(xpath = "//label[@id='genboxSelectBoxItText']")
    private WebElement selectedGender;


    private WebDriver driver;
    private WebDriverWait wait;

    public SinbadPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver,60);
        PageFactory.initElements(driver,this);
    }

    private void clickOnSubmit(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submitButton.click();
    }

    private void clickOnTitle(int number){
        WebElement button = driver.findElement(By.xpath("//span[@id='titleSelectBoxIt']"));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        if (number>=0){
            for(int i=0;i<number+1;i++){
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

    private void clickOnGender(int number){
        WebElement button = driver.findElement(By.xpath("//span[@id='genboxSelectBoxIt']"));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        if (number>=0){
            for(int i=0;i<number+1;i++){
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

    private void fillFirstName(String name){
        inputFirstName.click();
        inputFirstName.sendKeys(name);
    }

    private void fillLastName(String name){
        inputLastName.click();
        inputLastName.sendKeys(name);
    }

    private String clickOnSubmitAndGetErrors(){
        clickOnSubmit();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", errorMessage);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return errorMessage.getText();
    }

    public String tryToSignUpWithoutTitle(){
        return clickOnSubmitAndGetErrors();
    }

    public String checkTitleAndGenderMaleEquality(){
        clickOnTitle(0);
        WebElement selectedGen=driver.findElement(By.xpath("//span[@id='genboxSelectBoxItText']"));
        return selectedGen.getText();
    }

    public String checkTitleAndGenderFemaleEquality(){
        clickOnTitle(1);
        WebElement selectedGen=driver.findElement(By.xpath("//span[@id='genboxSelectBoxItText']"));
        return wait.until(ExpectedConditions.elementToBeClickable(selectedGen)).getText();
    }

    public String checkEmptyFirstNameWithFullTitle(){
        return clickOnSubmitAndGetErrors();
    }

    public String checkEmptyLastNameWithFullTitleAndFirstName(){
        fillFirstName("Andrey");
        return clickOnSubmitAndGetErrors();
    }

    public String checkEmptyDateOfBirthWithFullTitleAndFirstNameAndLastName(){
        fillLastName("Mir");
        return clickOnSubmitAndGetErrors();
    }

    public String checkInequalityOfTitleAndGenderError(){
        clickOnTitle(-2);
        clickOnGender(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", errorMessage);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return errorMessage.getText();
    }
}
