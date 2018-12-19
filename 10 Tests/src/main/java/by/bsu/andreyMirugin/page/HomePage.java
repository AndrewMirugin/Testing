package by.bsu.andreyMirugin.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {


    @FindBy(xpath = "//div[@class='evo-input as-text as-big as-cloned as-right destination-location']/span")
    private WebElement openDropDownTo;

    @FindBy(xpath = "//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front FlightOriginDropdown']/li")
    private List<WebElement> dropDownTo;

    @FindBy(xpath = "//div[@class='booking-button bfFlightSearchSubmitHomebtn']/button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='rotate-location']")
    private WebElement rotateLocations;

    @FindBy(xpath = "//input[@id='bfTo']")
    private WebElement toField;

    @FindBy(xpath = "//div[@class='errorDiv']/p")
    private WebElement errorField;

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private HomePage clickOnSearch(){
        searchButton.click();
        return this;
    }

    private HomePage setDestination(int numberFromList){
        openDropDownTo.click();
        dropDownTo.get(numberFromList-1).click();
        return this;
    }

    public String tryToSearchWithoutTo(){
        clickOnSearch();
        return errorField.getText();
    }

    public String tryToSearchWithoutReturnDate(){
        setDestination(1);
        clickOnSearch();
        return errorField.getText();
    }

    public String checkToAfterReplacement(){
        rotateLocations.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return toField.getAttribute("value");
    }


}
