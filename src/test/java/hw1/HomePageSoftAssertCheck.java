package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;


public class HomePageSoftAssertCheck {
    private WebDriver driver;

    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void beforeClass() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void HomePageSoftAssertTest(){
        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert title Home Page
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3 LogIn
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='name']")).isDisplayed();
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name
        WebElement username = driver.findElement (By.cssSelector("[id='user-name']"));
        softAssert.assertEquals(username.getText(), "PITER CHAILOVSKII");

        //5 Assert title Home Page
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert 4 items
        List<WebElement> topbar = driver.findElements (By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));

        softAssert.assertEquals(topbar.size(), 4);

        softAssert.assertEquals(topbar.get(0).getText(), "HOME");
        softAssert.assertEquals(topbar.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(topbar.get(2).getText(), "SERVICE");
        softAssert.assertEquals(topbar.get(3).getText(), "METALS & COLORS");

        //7 Assert 4 images
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        softAssert.assertEquals(images.size(), 4);
        for (int i = 0; i < 4; i++)
            softAssert.assertTrue(images.get(i).isDisplayed());

        //8 Assert 4 texts
        List<WebElement> texts = driver.findElements(By.cssSelector(".benefit-txt"));
        softAssert.assertEquals(texts.size(), 4);

        softAssert.assertEquals(texts.get(0).getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        softAssert.assertEquals(texts.get(1).getText(), "To be flexible and\n" + "customizable");
        softAssert.assertEquals(texts.get(2).getText(), "To be multiplatform");
        softAssert.assertEquals(texts.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more...");

        //9 Assert a text of the main headers
        softAssert.assertEquals(driver.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        softAssert.assertEquals(driver.findElement(By.name("jdi-text")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert iFrame
        WebElement iframe = driver.findElement (By.cssSelector("[id='iframe']"));
        softAssert.assertTrue(iframe.isDisplayed());

        //11 Assert logo inside of iframe
        driver.switchTo().frame("iframe");

        WebElement logo = driver.findElement(By.xpath(".//img[@id='epam_logo']"));
        softAssert.assertTrue(logo.isDisplayed());

        //12 Switch to the main window
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().window(windowHandler);

        //13 Assert test JDI GITHUB
        WebElement subHeader = driver.findElement(By.xpath(".//a[text()='JDI Github']"));
        softAssert.assertTrue(subHeader.isDisplayed());
        softAssert.assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert link JDI GITHUB
        softAssert.assertEquals(subHeader.getTagName(), "a");
        softAssert.assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert left section
        WebElement sidebarMenu = driver.findElement(By.xpath(".//ul[@class='sidebar-menu']"));
        softAssert.assertTrue(sidebarMenu.isDisplayed());

        //16 Assert footer
        WebElement footer = driver.findElement(By.xpath(".//div[contains(@class, 'footer-content')]"));
        softAssert.assertTrue(footer.isDisplayed());

        //!!!missed call for softAssert final check!!!
        softAssert.assertAll();

        //17 Close browser
        driver.close();
    }
}
