package hw3;

import HW3.HomePage;
import HW3.enums.Links;
import HW3.enums.Titles;
import HW3.enums.Users;
import base.SeleniumBase;
// TODO please do not forget delete unused imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

// TODO please do not forget delete unused imports
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageObjectTest extends SeleniumBase {
    private WebDriver driver;
    private HomePage homePage;

    // TODO please do not forget delete commented block of code
    /*@BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }*/

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }
    @AfterMethod
    public void afterMethod(){
        //17 Close browser
        driver.close();
    }

    @Test
    public void HomePageHardAssertTest(){
        //1 Open test site by URL
        homePage.open(Links.HPLink);

        //2 Assert title Home Page
        homePage.checkTitle(Titles.HPTitle);

        //3 LogIn
        homePage.login(Users.PITER);

        //4 Assert User name
        homePage.checkUserName(Users.PITER);

        //5 Assert title Home Page
        homePage.checkTitle(Titles.HPTitle);

        //6 Assert 4 items
        homePage.checkTopBar();

        //7 Assert 4 images
        homePage.checkImages();

        //8 Assert 4 texts
        homePage.checkTexts();

        //9 Assert a text of the main headers
        homePage.checkHeaderText();

        //10 Assert iFrame
        homePage.checkiFrame();

        //11 Assert logo inside of iframe
        homePage.checkLogo();

        //12 Switch to the main window
        homePage.switchiFrame();

        //13 Assert test JDI GITHUB
        homePage.titleJDI();

        //14 Assert link JDI GITHUB
        homePage.linkJDI();

        //15 Assert left section
        homePage.checkLeftSection();

        //16 Assert footer
        homePage.checkFooter();
    }
}
