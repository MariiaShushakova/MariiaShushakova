package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static hw2.LongStrings.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// TODO please remove unused imports - fixed

// TODO please pay attention for comments in HPRegression2Smoke1Test class - fixed
public class HPSmokeTest extends WebDriverThreadLocalImpl {

    @Test(groups = "Smoke")
    public void HPTest1(){

        //2 Assert title Home Page
        assertEquals(getDriver().getTitle(), "Home Page");

        //3 LogIn
        getDriver().findElement(By.cssSelector("[id='user-icon']")).click();
        getDriver().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        getDriver().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        getDriver().findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name
        WebElement username = getDriver().findElement(By.cssSelector("[id='user-name']"));
        assertEquals(username.getText(), "PITER CHAILOVSKII");

        //5 Assert title Home Page
        assertEquals(getDriver().getTitle(), "Home Page");

        //6 Assert 4 items
        List<WebElement> topbar = getDriver().findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(topbar.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(topbar.get(i).isDisplayed());
        }

        assertEquals(topbar.get(0).getText(), "HOME");
        assertEquals(topbar.get(1).getText(), "CONTACT FORM");
        assertEquals(topbar.get(2).getText(), "SERVICE");
        assertEquals(topbar.get(3).getText(), "METALS & COLORS");

        //7 Assert 4 images
        List<WebElement> images = getDriver().findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(images.get(i).isDisplayed());
        }

        //8 Assert 4 texts
        List<WebElement> texts = getDriver().findElements(By.cssSelector(".benefit-txt"));
        assertEquals(texts.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(texts.get(i).isDisplayed());
        }

        assertEquals(texts.get(0).getText(), BENEFIT_TEXT1.getValue());
        assertEquals(texts.get(1).getText(), BENEFIT_TEXT2.getValue());
        assertEquals(texts.get(2).getText(), BENEFIT_TEXT3.getValue());
        assertEquals(texts.get(3).getText(), BENEFIT_TEXT4.getValue());

        //9 Assert a text of the main headers
        assertEquals(getDriver().findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(getDriver().findElement(By.name("jdi-text")).getText(), LOREM_IPSUM.getValue());

        //10 Assert iFrame
        WebElement iframe = getDriver().findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iframe.isDisplayed());

        //11 Assert logo inside of iframe
        getDriver().switchTo().frame("iframe");

        WebElement logo = getDriver().findElement(By.xpath(".//img[@id='epam_logo']"));
        assertTrue(logo.isDisplayed());

        //12 Switch to the main window
        String windowHandler = getDriver().getWindowHandle();
        getDriver().switchTo().window(windowHandler);

        //13 Assert test JDI GITHUB
        WebElement subHeader = getDriver().findElement(By.xpath(".//a[text()='JDI Github']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert link JDI GITHUB
        assertEquals(subHeader.getTagName(), "a");
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert left section
        WebElement sidebarMenu = getDriver().findElement(By.xpath(".//ul[@class='sidebar-menu']"));
        assertTrue(sidebarMenu.isDisplayed());

        //16 Assert footer
        WebElement footer = getDriver().findElement(By.xpath(".//div[contains(@class, 'footer-content')]"));
        assertTrue(footer.isDisplayed());

    }

    @Test(groups = "Smoke")
    public void HPTest2(){

        //2 Assert title Home Page
        assertEquals(getDriver().getTitle(), "Home Page");

        //3 LogIn
        getDriver().findElement(By.cssSelector("[id='user-icon']")).click();
        getDriver().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        getDriver().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        getDriver().findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name
        WebElement username = getDriver().findElement(By.cssSelector("[id='user-name']"));
        assertEquals(username.getText(), "PITER CHAILOVSKII");

        //5 Assert title Home Page
        assertEquals(getDriver().getTitle(), "Home Page");

        //6 Assert 4 items
        List<WebElement> topbar = getDriver().findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(topbar.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(topbar.get(i).isDisplayed());
        }

        assertEquals(topbar.get(0).getText(), "HOME");
        assertEquals(topbar.get(1).getText(), "CONTACT FORM");
        assertEquals(topbar.get(2).getText(), "SERVICE");
        assertEquals(topbar.get(3).getText(), "METALS & COLORS");

        //7 Assert 4 images
        List<WebElement> images = getDriver().findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(images.get(i).isDisplayed());
        }

        //8 Assert 4 texts
        List<WebElement> texts = getDriver().findElements(By.cssSelector(".benefit-txt"));
        assertEquals(texts.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(texts.get(i).isDisplayed());
        }

        assertEquals(texts.get(0).getText(), BENEFIT_TEXT1.getValue());
        assertEquals(texts.get(1).getText(), BENEFIT_TEXT2.getValue());
        assertEquals(texts.get(2).getText(), BENEFIT_TEXT3.getValue());
        assertEquals(texts.get(3).getText(), BENEFIT_TEXT4.getValue());

        //9 Assert a text of the main headers
        assertEquals(getDriver().findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(getDriver().findElement(By.name("jdi-text")).getText(), LOREM_IPSUM.getValue());

        //10 Assert iFrame
        WebElement iframe = getDriver().findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iframe.isDisplayed());

        //11 Assert logo inside of iframe
        getDriver().switchTo().frame("iframe");

        WebElement logo = getDriver().findElement(By.xpath(".//img[@id='epam_logo']"));
        assertTrue(logo.isDisplayed());

        //12 Switch to the main window
        String windowHandler = getDriver().getWindowHandle();
        getDriver().switchTo().window(windowHandler);

        //13 Assert test JDI GITHUB
        WebElement subHeader = getDriver().findElement(By.xpath(".//a[text()='JDI Github']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert link JDI GITHUB
        assertEquals(subHeader.getTagName(), "a");
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert left section
        WebElement sidebarMenu = getDriver().findElement(By.xpath(".//ul[@class='sidebar-menu']"));
        assertTrue(sidebarMenu.isDisplayed());

        //16 Assert footer
        WebElement footer = getDriver().findElement(By.xpath(".//div[contains(@class, 'footer-content')]"));
        assertTrue(footer.isDisplayed());

    }

    @Test(groups = "Smoke")
    public void HPTest3(){

        //2 Assert title Home Page
        assertEquals(getDriver().getTitle(), "Home Page");

        //3 LogIn
        getDriver().findElement(By.cssSelector("[id='user-icon']")).click();
        getDriver().findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        getDriver().findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        getDriver().findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name
        WebElement username = getDriver().findElement(By.cssSelector("[id='user-name']"));
        assertEquals(username.getText(), "PITER CHAILOVSKII");

        //5 Assert title Home Page
        assertEquals(getDriver().getTitle(), "Home Page");

        //6 Assert 4 items
        List<WebElement> topbar = getDriver().findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        assertEquals(topbar.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(topbar.get(i).isDisplayed());
        }

        assertEquals(topbar.get(0).getText(), "HOME");
        assertEquals(topbar.get(1).getText(), "CONTACT FORM");
        assertEquals(topbar.get(2).getText(), "SERVICE");
        assertEquals(topbar.get(3).getText(), "METALS & COLORS");

        //7 Assert 4 images
        List<WebElement> images = getDriver().findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(images.get(i).isDisplayed());
        }

        //8 Assert 4 texts
        List<WebElement> texts = getDriver().findElements(By.cssSelector(".benefit-txt"));
        assertEquals(texts.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(texts.get(i).isDisplayed());
        }

        assertEquals(texts.get(0).getText(), BENEFIT_TEXT1.getValue());
        assertEquals(texts.get(1).getText(), BENEFIT_TEXT2.getValue());
        assertEquals(texts.get(2).getText(), BENEFIT_TEXT3.getValue());
        assertEquals(texts.get(3).getText(), BENEFIT_TEXT4.getValue());

        //9 Assert a text of the main headers
        assertEquals(getDriver().findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(getDriver().findElement(By.name("jdi-text")).getText(), LOREM_IPSUM.getValue());

        //10 Assert iFrame
        WebElement iframe = getDriver().findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iframe.isDisplayed());

        //11 Assert logo inside of iframe
        getDriver().switchTo().frame("iframe");

        WebElement logo = getDriver().findElement(By.xpath(".//img[@id='epam_logo']"));
        assertTrue(logo.isDisplayed());

        //12 Switch to the main window
        String windowHandler = getDriver().getWindowHandle();
        getDriver().switchTo().window(windowHandler);

        //13 Assert test JDI GITHUB
        WebElement subHeader = getDriver().findElement(By.xpath(".//a[text()='JDI Github']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert link JDI GITHUB
        assertEquals(subHeader.getTagName(), "a");
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert left section
        WebElement sidebarMenu = getDriver().findElement(By.xpath(".//ul[@class='sidebar-menu']"));
        assertTrue(sidebarMenu.isDisplayed());

        //16 Assert footer
        WebElement footer = getDriver().findElement(By.xpath(".//div[contains(@class, 'footer-content')]"));
        assertTrue(footer.isDisplayed());

    }
}


