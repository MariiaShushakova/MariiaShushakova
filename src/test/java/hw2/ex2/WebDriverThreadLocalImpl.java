package hw2.ex2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class WebDriverThreadLocalImpl {
    private static final String TEST_URL = "https://epam.github.io/JDI/";

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    @BeforeMethod(groups = {"Regression", "Smoke"})
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        webDriver.set(new ChromeDriver());
        getDriver().get(TEST_URL);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    @AfterMethod(groups = {"Regression", "Smoke"})
    public void closeBrowser() {
        webDriver.get().quit();
    }

}
