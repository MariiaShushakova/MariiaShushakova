package hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hw8.entities.MetalsColorsFormData;
import hw8.entities.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import static hw8.JDISite.jdiHomePage;
import static hw8.JDISite.metalsColorsPage;
import static hw8.enums.Navigation.METALS_COLORS;

public class JdiDataProviderTest {

    public static final String DATA_SET_JSON = "src/test/resources/hw8/JDI_ex8_metalsColorsDataSet.json";
    public static final String CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String CHROME_DRIVER_PATH = "\\src\\main\\resources\\chromedriver.exe";

    @BeforeMethod
    public void beforeMethod() {
        //setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        PageFactory.initElements(JDISite.class);
        jdiHomePage.open();
    }

    // TODO Take a look on IDEA warning
    @Test(dataProvider = "provideData")
    public void JdiDataProviderTest(MetalsColorsFormData data) {

        //1 Log in to the system
        jdiHomePage.login(User.PITER);

        //2 Open Metal&Colors tab
        jdiHomePage.openMenu(METALS_COLORS);

        //3 Fill out the form
        metalsColorsPage.form.fillForm(data);

        //4 Submit the form
        metalsColorsPage.form.submitForm();

        //5 Check the results
        metalsColorsPage.checkResult(data);
    }

    @DataProvider
    public Object[][] provideData() throws FileNotFoundException {
        JsonObject jsonMap = new JsonParser()
                .parse(new FileReader(DATA_SET_JSON))
                .getAsJsonObject();
        Object[][] returnedArray = new Object[jsonMap.size()][1];
        // TODO What is the reason for foreach loop here ? Why don't you use fori ?
        int i = 0;
        for (Map.Entry<String, JsonElement> entry : jsonMap.entrySet()) {
            returnedArray[i++][0] = new Gson()
                    .fromJson(entry.getValue(), MetalsColorsFormData.class);
        }
        return returnedArray;
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverFactory.close();
    }
}
