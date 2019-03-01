package lessons.jdi;

import base.JDI.JDISite;
import base.JDI.entities.User;
import com.epam.jdi.light.actions.ActionHelper;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JDISimpleTest {
//    JDIHomePage jdiHomePage;
//    private ChromeDriver driver;

    @BeforeSuite
    public void beforeSuite(){
//        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.navigate().to("https://epam.github.io/JDI/");
//        jdiHomePage = PageFactory.initElements(driver, JDIHomePage.class);
        WebSettings.logger.setLogLevel(LogLevels.INFO);
        WebSettings.SEARCH_CONDITION = WebElement::isDisplayed;

        PageFactory.initElements(JDISite.class);

        ActionHelper.BEFORE_JDI_ACTION = jp -> {

        };
        ActionHelper.AFTER_JDI_ACTION = (jp, o) -> {
            return ActionHelper.AFTER_STEP_ACTION.execute(jp, o);
        };
        WebSettings.SEARCH_CONDITION = e ->{
            return e.isDisplayed();
        };
    }

    @Test
    public void setJdiSimpleTest(){
        //jdiHomePage.login(Users.PITER);
        JDISite.jdiHomePage.open();
        JDISite.jdiHomePage.login(User.PITER);
    }

    @AfterMethod
    public void afterMethod(){
        WebDriverFactory.close();
//        driver.close();
    }

}
