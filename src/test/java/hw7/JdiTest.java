package hw7;

import base.JDI.JDISite;
import base.JDI.entities.MetalsColors;
import base.JDI.entities.User;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static base.JDI.JDISite.jdiHomePage;
import static base.JDI.JDISite.metalsColorsPage;
import static base.JDI.enums.Navigation.METALS_COLORS;

public class JdiTest {
    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    @Test
    public void simpleJdiTest() {

        jdiHomePage.open();
        jdiHomePage.login(User.PITER);
        jdiHomePage.openMenu(METALS_COLORS);

        metalsColorsPage.fillForm(MetalsColors.DATASET);
        metalsColorsPage.submitForm();
        metalsColorsPage.checkForm(MetalsColors.DATASET);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}
