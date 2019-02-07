package lesson4;

import base.SelenideBase;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;

public class SelenideSimpleTest extends SelenideBase {
    @Test
    public void simpleTest() {
        //1
        //2
        open("https://epam.github.io/JDI/index.html");
        //3
        assertEquals(getWebDriver().getTitle(), "Home Page");
        //4
        $("[id='user-icon']").click();
        $("[id='name']").sendKeys("epam");
        $("[id='password']").sendKeys("1234");
        $("[id='login-button']").click();
        $("#user-name").shouldHave(text("Piter Chailovskii"));
        //5
        close();
    }
}

