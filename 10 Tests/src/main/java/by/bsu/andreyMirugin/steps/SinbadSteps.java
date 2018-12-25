package by.bsu.andreyMirugin.steps;

import by.bsu.andreyMirugin.elems.SinbadElems;
import by.bsu.andreyMirugin.page.SinbadPage;
import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SinbadSteps {

    private WebDriver driver;
    private SinbadPage sinbadPage;
    private SinbadElems sinbadElems;


    public SinbadSteps(SinbadElems sinbadElems, SinbadPage sinbadPage) {
        this.driver = Driver.getDriver();
        this.sinbadElems = sinbadElems;
        this.sinbadPage = sinbadPage;
        PageFactory.initElements(driver,this);
    }


    public String clickOnSubmitAndGetErrors(){
        sinbadPage.clickOnSubmit();
        return sinbadElems.getErrorMessage().getText();
    }
}
