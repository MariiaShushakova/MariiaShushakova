package hw3;

import hw3.enums.Links;
import hw3.enums.Titles;
import hw4.enums.Users;
import base.SeleniumBase;
// TODO please do not forget delete unused imports - fixed
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

// TODO please do not forget delete unused imports - fixed


public class HomePageObjectTest extends SeleniumBase {
    private WebDriver driver;
    private HomePage homePage;

    // TODO please do not forget delete commented block of code - fixed

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

    @Test
    public void HomePageHardAssertTest(){
        //1 Open test site by URL
        homePage.open(Links.HP_LINK);

        //2 Assert title Home Page
        homePage.checkTitle(Titles.HP_TITLE);

        //3 LogIn
        homePage.login(Users.PITER);

        //4 Assert User name
        homePage.checkUserName(Users.PITER);

        //5 Assert title Home Page
        homePage.checkTitle(Titles.HP_TITLE);

        //6 Assert 4 items
        homePage.checkTopBar();

        //7 Assert 4 images
        homePage.checkBenefitIcons();

        //8 Assert 4 texts
        homePage.checkBenefitTexts();

        //9 Assert a text of the main headers
        homePage.checkHeaderText();

        //10 Assert iFrame
        homePage.checkiFrame();

        //11 Assert logo inside of iframe
        homePage.checkLogo();

        //12 Switch to the main window
        homePage.swtichFromIFrameToWindow();

        //13 Assert test JDI GITHUB
        homePage.titleJDI();

        //14 Assert link JDI GITHUB
        homePage.checkLinkJDI();

        //15 Assert left section
        homePage.checkLeftSection();

        //16 Assert footer
        homePage.checkFooter();
    }
}
