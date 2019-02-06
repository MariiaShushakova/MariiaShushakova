package hw2.ex1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AssertTextDataProvider extends SeleniumBase {


    // TODO Exist one more way how to parallel tests (use @BeforeTest)
    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest(){
        driver.close();
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

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Find texts and assert value
        List<WebElement> texts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(texts.size(), 4);

        assertEquals(texts.get(itemIndex).getText(), benefitText);



    }


}
