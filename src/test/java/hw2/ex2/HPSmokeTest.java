package hw2.ex2;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HPSmokeTest extends SeleniumBase {

    @Test(groups = "Smoke")
    public void HPSmokeTest1(){
        //new instance of browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert title Home Page
        assertEquals(driver.getTitle(), "Home Page");

        //3 LogIn
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).isDisplayed();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name
        WebElement username = driver.findElement(By.cssSelector("[id='user-name']"));
        assertEquals(username.getText(), "PITER CHAILOVSKII");

        //5 Assert title Home Page
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert 4 items
        //!!!check that elements are displayed
        List<WebElement> topbar = driver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(topbar.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(topbar.get(i).isDisplayed());

        assertEquals(topbar.get(0).getText(), "HOME");
        assertEquals(topbar.get(1).getText(), "CONTACT FORM");
        assertEquals(topbar.get(2).getText(), "SERVICE");
        assertEquals(topbar.get(3).getText(), "METALS & COLORS");

        //7 Assert 4 images
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(images.get(i).isDisplayed());

        //8 Assert 4 texts
        //!!!check that elements are displayed
        List<WebElement> texts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(texts.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(texts.get(i).isDisplayed());

        assertEquals(texts.get(0).getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        assertEquals(texts.get(1).getText(), "To be flexible and\n" + "customizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        //9 Assert a text of the main headers
        assertEquals(driver.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.name("jdi-text")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

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

        //17 Close browser
        driver.close();
    }

    @Test(groups = "Smoke")
    public void HPSmokeTest2(){
        //new instance of browser
        driver2 = new ChromeDriver();
        driver2.manage().window().maximize();
        driver2.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

        //1 Open test site by URL
        driver2.navigate().to("https://epam.github.io/JDI/");

        //2 Assert title Home Page
        assertEquals(driver2.getTitle(), "Home Page");

        //3 LogIn
        driver2.findElement(By.cssSelector("[id='user-icon']")).click();
        driver2.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver2.findElement(By.cssSelector("[id='name']")).isDisplayed();
        driver2.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver2.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name
        WebElement username = driver2.findElement(By.cssSelector("[id='user-name']"));
        assertEquals(username.getText(), "PITER CHAILOVSKII");

        //5 Assert title Home Page
        assertEquals(driver2.getTitle(), "Home Page");

        //6 Assert 4 items
        //!!!check that elements are displayed
        List<WebElement> topbar = driver2.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(topbar.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(topbar.get(i).isDisplayed());

        assertEquals(topbar.get(0).getText(), "HOME");
        assertEquals(topbar.get(1).getText(), "CONTACT FORM");
        assertEquals(topbar.get(2).getText(), "SERVICE");
        assertEquals(topbar.get(3).getText(), "METALS & COLORS");

        //7 Assert 4 images
        List<WebElement> images = driver2.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(images.get(i).isDisplayed());

        //8 Assert 4 texts
        //!!!check that elements are displayed
        List<WebElement> texts = driver2.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(texts.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(texts.get(i).isDisplayed());

        assertEquals(texts.get(0).getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        assertEquals(texts.get(1).getText(), "To be flexible and\n" + "customizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        //9 Assert a text of the main headers
        assertEquals(driver2.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver2.findElement(By.name("jdi-text")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert iFrame
        WebElement iframe = driver2.findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iframe.isDisplayed());

        //11 Assert logo inside of iframe
        driver2.switchTo().frame("iframe");

        WebElement logo = driver2.findElement(By.xpath(".//img[@id='epam_logo']"));
        assertTrue(logo.isDisplayed());

        //12 Switch to the main window
        String windowHandler = driver2.getWindowHandle();
        driver2.switchTo().window(windowHandler);

        //13 Assert test JDI GITHUB
        WebElement subHeader = driver2.findElement(By.xpath(".//a[text()='JDI Github']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert link JDI GITHUB
        assertEquals(subHeader.getTagName(), "a");
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert left section
        WebElement sidebarMenu = driver2.findElement(By.xpath(".//ul[@class='sidebar-menu']"));
        assertTrue(sidebarMenu.isDisplayed());

        //16 Assert footer
        WebElement footer = driver2.findElement(By.xpath(".//div[contains(@class, 'footer-content')]"));
        assertTrue(footer.isDisplayed());

        //17 Close browser
        driver2.close();
    }

    @Test(groups = "Smoke")
    public void HPSmokeTest3(){
        //new instance of browser
        driver3 = new ChromeDriver();
        driver3.manage().window().maximize();
        driver3.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

        //1 Open test site by URL
        driver3.navigate().to("https://epam.github.io/JDI/");

        //2 Assert title Home Page
        assertEquals(driver3.getTitle(), "Home Page");

        //3 LogIn
        driver3.findElement(By.cssSelector("[id='user-icon']")).click();
        driver3.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver3.findElement(By.cssSelector("[id='name']")).isDisplayed();
        driver3.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver3.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name
        WebElement username = driver3.findElement(By.cssSelector("[id='user-name']"));
        assertEquals(username.getText(), "PITER CHAILOVSKII");

        //5 Assert title Home Page
        assertEquals(driver3.getTitle(), "Home Page");

        //6 Assert 4 items
        //!!!check that elements are displayed
        List<WebElement> topbar = driver3.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(topbar.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(topbar.get(i).isDisplayed());

        assertEquals(topbar.get(0).getText(), "HOME");
        assertEquals(topbar.get(1).getText(), "CONTACT FORM");
        assertEquals(topbar.get(2).getText(), "SERVICE");
        assertEquals(topbar.get(3).getText(), "METALS & COLORS");

        //7 Assert 4 images
        List<WebElement> images = driver3.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(images.get(i).isDisplayed());

        //8 Assert 4 texts
        //!!!check that elements are displayed
        List<WebElement> texts = driver3.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(texts.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(texts.get(i).isDisplayed());

        assertEquals(texts.get(0).getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM project");
        assertEquals(texts.get(1).getText(), "To be flexible and\n" + "customizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        //9 Assert a text of the main headers
        assertEquals(driver3.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver3.findElement(By.name("jdi-text")).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert iFrame
        WebElement iframe = driver3.findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iframe.isDisplayed());

        //11 Assert logo inside of iframe
        driver3.switchTo().frame("iframe");

        WebElement logo = driver3.findElement(By.xpath(".//img[@id='epam_logo']"));
        assertTrue(logo.isDisplayed());

        //12 Switch to the main window
        String windowHandler = driver3.getWindowHandle();
        driver3.switchTo().window(windowHandler);

        //13 Assert test JDI GITHUB
        WebElement subHeader = driver3.findElement(By.xpath(".//a[text()='JDI Github']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert link JDI GITHUB
        assertEquals(subHeader.getTagName(), "a");
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert left section
        WebElement sidebarMenu = driver3.findElement(By.xpath(".//ul[@class='sidebar-menu']"));
        assertTrue(sidebarMenu.isDisplayed());

        //16 Assert footer
        WebElement footer = driver3.findElement(By.xpath(".//div[contains(@class, 'footer-content')]"));
        assertTrue(footer.isDisplayed());

        //17 Close browser
        driver3.close();
    }

}


