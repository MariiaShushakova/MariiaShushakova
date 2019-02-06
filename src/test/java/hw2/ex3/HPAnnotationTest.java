package hw2.ex3;

import base.SeleniumBase;
import org.openqa.selenium.By;
// TODO please remove unused imports - fixed
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
// TODO please remove unused imports - fixed
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HPAnnotationTest extends SeleniumBase{

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println(driver.getTitle());
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }


    @Test
    // TODO please pay attention for comments in HPRegression2Smoke1Test class - fixed
    public void HomePageHardAssertTest1(){
        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert title Home Page
        assertEquals(driver.getTitle(), "Home Page");

        //3 LogIn
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name
        WebElement username = driver.findElement(By.cssSelector("[id='user-name']"));
        assertEquals(username.getText(), "PITER CHAILOVSKII");

        //5 Assert title Home Page
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert 4 items
        List<WebElement> topbar = driver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(topbar.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(topbar.get(i).isDisplayed());
        }

        assertEquals(topbar.get(0).getText(), "HOME");
        assertEquals(topbar.get(1).getText(), "CONTACT FORM");
        assertEquals(topbar.get(2).getText(), "SERVICE");
        assertEquals(topbar.get(3).getText(), "METALS & COLORS");

        //7 Assert 4 images
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(images.get(i).isDisplayed());
        }

        //8 Assert 4 texts
        List<WebElement> texts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(texts.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(texts.get(i).isDisplayed());
        }

        assertEquals(texts.get(0).getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        assertEquals(texts.get(1).getText(), "To be flexible and\n" + "customizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        //9 Assert a text of the main headers
        assertEquals(driver.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.name("jdi-text")).getText(), LOREM_IPSUM);

        //10 Assert iFrame
        WebElement iframe = driver.findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iframe.isDisplayed());

        //11 Assert logo inside of iframe
        driver.switchTo().frame("iframe");

        WebElement logo = driver.findElement(By.xpath(".//img[@id='epam_logo']"));
        assertTrue(logo.isDisplayed());

        //12 Switch to the main window
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().window(windowHandler);

        //13 Assert test JDI GITHUB
        WebElement subHeader = driver.findElement(By.xpath(".//a[text()='JDI Github']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert link JDI GITHUB
        assertEquals(subHeader.getTagName(), "a");
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert left section
        WebElement sidebarMenu = driver.findElement(By.xpath(".//ul[@class='sidebar-menu']"));
        assertTrue(sidebarMenu.isDisplayed());

        //16 Assert footer
        WebElement footer = driver.findElement(By.xpath(".//div[contains(@class, 'footer-content')]"));
        assertTrue(footer.isDisplayed());
    }

}


