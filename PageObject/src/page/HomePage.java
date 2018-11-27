package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    @FindBy(xpath = "//div[@class=\"evo-input as-text as-big as-cloned as-right destination-location\"]/span")
    WebElement openDropDown;
    @FindBy(xpath = "//ul[@class=\"ui-menu ui-widget ui-widget-content ui-autocomplete ui-front FlightOriginDropdown\"]/li")
    List<WebElement> dropDownTo;
    @FindBy(xpath = "//div[@class=\"booking-button bfFlightSearchSubmitHomebtn\"]/button")
    WebElement searchButton;
    @FindBy(xpath = "//div[@class=\"errorDiv\"]/p")
    WebElement errorField;

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
        openDropDown.click();
        dropDownTo.get(numberFromList-1).click();
        return this;
    }

    public String tryToSearchWithoutReturnDate(){
        setDestination(1);
        clickOnSearch();
        return errorField.getText();
    }



}
