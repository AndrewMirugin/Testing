package by.bsu.andreyMirugin.elems;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SinbadElems {

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

    @FindBy(xpath = "//label[@id='genboxSelectBoxItText']")
    private WebElement selectedGender;


    private WebDriver driver;


    public SinbadElems(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private void navigateTo(WebElement elem){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement getOpenTitleSpisButton() {
        navigateTo(openTitleSpisButton);
        return openTitleSpisButton;
    }

    public WebElement getInputFirstName() {
        navigateTo(inputFirstName);
        return inputFirstName;
    }

    public WebElement getInputLastName() {
        navigateTo(inputLastName);
        return inputLastName;
    }

    public WebElement getInputDate() {
        navigateTo(inputDate);
        return inputDate;
    }

    public WebElement getSubmitButton() {
        navigateTo(submitButton);
        return submitButton;
    }

    public WebElement getErrorMessage() {
        navigateTo(errorMessage);
        return errorMessage;
    }

    public WebElement getSelectedGender() {
        navigateTo(selectedGender);
        return selectedGender;
    }

    public WebElement getSelectedGen(){
        return driver.findElement(By.xpath("//span[@id='genboxSelectBoxItText']"));
    }
}
