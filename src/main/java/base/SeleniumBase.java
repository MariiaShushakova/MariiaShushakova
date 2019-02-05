package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class SeleniumBase {
    protected WebDriver driver;
    protected WebDriver driver2;
    protected WebDriver driver3;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        System.out.println(System.currentTimeMillis());
    }
}
