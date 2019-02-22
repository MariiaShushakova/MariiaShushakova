package hw6;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(
        features = {"classpath:hw6"},
        glue = {"classpath:hw6.steps"},
        tags = {"@DifferentElements, @UserTable"}
)

public class Runner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void openSession() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }

    @AfterClass
    public void closeSession() {
        close();
    }
}
