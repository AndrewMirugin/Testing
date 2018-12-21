package by.bsu.andreyMirugin;

import by.bsu.andreyMirugin.elems.SinbadElems;
import by.bsu.andreyMirugin.steps.SinbadSteps;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import by.bsu.andreyMirugin.page.HomePage;
import by.bsu.andreyMirugin.page.SinbadPage;

public class TestOmanAir {
    private WebDriverWait wait;
    private WebDriver driver;
    private HomePage homePage;
    private SinbadPage sinbadPage;
    private SinbadElems sinbadElems;
    private SinbadSteps sinbadSteps;

    @BeforeSuite
    public void start() {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver,60);
        sinbadPage = new SinbadPage(driver);
        sinbadElems = new SinbadElems(driver);
        sinbadSteps = new SinbadSteps(driver,sinbadElems,sinbadPage);
    }

    @BeforeGroups(groups = "mainPage")
    public void startGroupMainPage(){
        driver.navigate().to("https://www.omanair.com/");
    }

    @BeforeGroups(groups = "sinbadPage",dependsOnGroups = "mainPage")
    public void goToSinbadPage(){
        driver.navigate().to("https://sindbad.omanair.com/SindbadProd/enroll/joinNow");
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
    }

    @AfterSuite
    public void finish(){
        driver.close();
    }

    @Test(groups = "mainPage")
    public void tryToSearchWithoutTo(){
        Assert.assertEquals(homePage.tryToSearchWithoutTo(),"Please select To station");
    }

    @Test(groups = "mainPage",dependsOnMethods = "tryToSearchWithoutTo")
    public void tryToSearchWithoutReturnDate(){
        Assert.assertEquals(homePage.tryToSearchWithoutReturnDate(),"Please select a return date");
    }

    @Test(groups = "mainPage",dependsOnMethods = "tryToSearchWithoutReturnDate")
    public void checkToAfterReplacement(){
        Assert.assertEquals(homePage.checkToAfterReplacement(),"Muscat, Oman");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage")
    public void tryToSignUpWithoutTitle(){
        Assert.assertEquals(sinbadSteps.clickOnSubmitAndGetErrors(),"Please select a title.");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="tryToSignUpWithoutTitle")
    public void checkTitleAndGenderMaleEquality(){
        sinbadPage.clickOnTitle(0);
        String selectedGen = wait.until(ExpectedConditions.elementToBeClickable(sinbadElems.getSelectedGen())).getText();
        Assert.assertEquals(selectedGen,"Male");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="checkTitleAndGenderMaleEquality")
    public void checkTitleAndGenderFemaleEquality(){
        sinbadPage.clickOnTitle(1);
        String selectedGen = wait.until(ExpectedConditions.elementToBeClickable(sinbadElems.getSelectedGen())).getText();
        Assert.assertEquals(selectedGen,"Female");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="checkTitleAndGenderFemaleEquality")
    public void checkErrorEmptyFirstNameWithFullTitle(){
        Assert.assertEquals(sinbadSteps.clickOnSubmitAndGetErrors(),"Please enter your First name as given in your passport.");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="checkErrorEmptyFirstNameWithFullTitle")
    public void checkErrorEmptyLastNameWithFullTitleAndFirstName(){
        sinbadPage.fillFirstName("Andrey");
        Assert.assertEquals(sinbadSteps.clickOnSubmitAndGetErrors(),"Please enter your Last name as given in your passport.");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="checkErrorEmptyLastNameWithFullTitleAndFirstName")
    public void checkErrorEmptyDateOfBirthWithFullTitleAndFirstNameAndLastName(){
        sinbadPage.fillLastName("Mir");
        Assert.assertEquals(sinbadSteps.clickOnSubmitAndGetErrors(),"Please enter your Date of Birth.");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="checkErrorEmptyDateOfBirthWithFullTitleAndFirstNameAndLastName")
    public void checkErrorInequalityOfTitleAndGenderError(){
        sinbadPage.clickOnTitle(-2);
        sinbadPage.clickOnGender(1);
        Assert.assertEquals(sinbadElems.getErrorMessage().getText(),"Title is not valid for this gender. Please change your title option");
    }

}
