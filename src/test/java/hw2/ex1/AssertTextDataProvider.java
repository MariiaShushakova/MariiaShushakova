package hw2.ex1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class AssertTextDataProvider extends SeleniumBase {
    private WebDriver driver;

//    @BeforeClass
//    public void beforeClass() {
//        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] textData() {
        return new Object[][] {
                {0, "To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {1, "To be flexible and\n" + "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }


    @Test(dataProvider = "textData")
    public void AssertText(int i, String s) {

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2
        List<WebElement> texts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(texts.size(), 4);


        assertEquals(s, texts.get(i).getText());

    }


}
