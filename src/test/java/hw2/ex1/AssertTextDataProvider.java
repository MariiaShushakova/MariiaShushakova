package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AssertTextDataProvider {

    private static final String TEST_URL = "https://epam.github.io/JDI/";

    // TODO Exist one more way how to parallel tests (use @BeforeTest)
    // used @BeforeMethod and ThreadLocal for webDriver - don't how to implement it via @BeforeTest

    protected static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        webDriver.set(new ChromeDriver());
        getDriver().get(TEST_URL);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        webDriver.get().close();
    }

    @DataProvider (parallel = true)
    public Object[][] textData() {
        return new Object[][] {
                {0, "To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {1, "To be flexible and\n" + "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }

    @Test(dataProvider = "textData")
    /* TODO
        * What does i means? - i is for itemIndex - fixed
        * What does s means? - s is for benefitText - fixed
     */
    public void AssertText(int itemIndex, String benefitText) {

        //2 Find texts and assert value
        List<WebElement> texts = getDriver().findElements(By.cssSelector(".benefit-txt"));

        assertEquals(texts.size(), 4);
        assertEquals(texts.get(itemIndex).getText(), benefitText);

    }
}
