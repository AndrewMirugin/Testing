package by.bsu.andreyMirugin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import by.bsu.andreyMirugin.page.HomePage;
import by.bsu.andreyMirugin.page.SinbadPage;

public class OmanAir {
    private WebDriver driver;
    private HomePage homePage;
    private SinbadPage sinbadPage;

    @BeforeSuite
    public void start() {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        sinbadPage = new SinbadPage(driver);
    }

    @BeforeGroups(groups = "mainPage")
    public void startGroupMainPage(){
        driver.navigate().to("https://www.omanair.com/");
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

    @BeforeGroups(groups = "sinbadPage",dependsOnGroups = "mainPage")
    public void goToSinbadPage(){
        driver.navigate().to("https://sindbad.omanair.com/SindbadProd/enroll/joinNow");
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage")
    public void tryToSignUpWithoutTitle(){
        Assert.assertEquals(sinbadPage.tryToSignUpWithoutTitle(),"Please select a title.");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="tryToSignUpWithoutTitle")
    public void checkTitleAndGenderMaleEquality(){
        Assert.assertEquals(sinbadPage.checkTitleAndGenderMaleEquality(),"Male");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="checkTitleAndGenderMaleEquality")
    public void checkTitleAndGenderFemaleEquality(){
        Assert.assertEquals(sinbadPage.checkTitleAndGenderFemaleEquality(),"Female");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="checkTitleAndGenderFemaleEquality")
    public void checkEmptyFirstNameWithFullTitle(){
        Assert.assertEquals(sinbadPage.checkEmptyFirstNameWithFullTitle(),"Please enter your First name as given in your passport.");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="checkEmptyFirstNameWithFullTitle")
    public void checkEmptyLastNameWithFullTitleAndFirstName(){
        Assert.assertEquals(sinbadPage.checkEmptyLastNameWithFullTitleAndFirstName(),"Please enter your Last name as given in your passport.");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="checkEmptyLastNameWithFullTitleAndFirstName")
    public void checkEmptyDateOfBirthWithFullTitleAndFirstNameAndLastName(){
        Assert.assertEquals(sinbadPage.checkEmptyDateOfBirthWithFullTitleAndFirstNameAndLastName(),"Please enter your Date of Birth.");
    }

    @Test(groups = "sinbadPage",dependsOnGroups = "mainPage",dependsOnMethods ="checkEmptyDateOfBirthWithFullTitleAndFirstNameAndLastName")
    public void checkInequalityOfTitleAndGenderError(){
        Assert.assertEquals(sinbadPage.checkInequalityOfTitleAndGenderError(),"Title is not valid for this gender. Please change your title option");
    }

    @AfterSuite
    public void finish(){
        //driver.close();
    }
}
