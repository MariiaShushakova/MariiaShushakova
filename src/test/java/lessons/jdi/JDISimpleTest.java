package lessons.jdi;

import HW4.enums.Users;
import base.JDI.JDIHomePage;
import com.epam.jdi.light.ui.html.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

public class JDISimpleTest {
    JDIHomePage jdiHomePage;
    private ChromeDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://epam.github.io/JDI/");
        jdiHomePage = PageFactory.initElements(driver, JDIHomePage.class);
    }

    @Test
    public void setJdiSimpleTest(){
        jdiHomePage.login(Users.PITER);
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

}
