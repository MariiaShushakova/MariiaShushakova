package lessons.lesson4;

import base.PageObject.SelenideHomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SelenideSimpleTestWithPO {
    private SelenideHomePage homePage;

        @BeforeMethod
        public void initTest(){
            open("https://epam.github.io/JDI/index.html");
            homePage = page(SelenideHomePage.class);
        }
        @AfterMethod
        public void closeTest(){
            close();
        }
        @Test
        public void SimpleTest(){
            homePage.login("epam", "1234");
        }
}
