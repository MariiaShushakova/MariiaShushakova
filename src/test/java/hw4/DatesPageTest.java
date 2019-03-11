package hw4;

import hw4.pages.DatesPage;
import hw4.pages.HomePage;
import base.SelenideBase;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw4.enums.Links.HP_LINK;
import static hw4.enums.ServiceMenus.DATES;
import static hw4.enums.Titles.HP_TITLE;
import static hw4.enums.Users.PITER;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;

public class DatesPageTest extends SelenideBase {
    private DatesPage datesPage;
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        Selenide.open(HP_LINK.getValue());
        homePage = page(HomePage.class);
        datesPage = page(DatesPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        // Close web driver
        close();
    }

    //TODO move test to separate file - DONE
    //Test fails each time when I run it
    @Test
    public void datesPageTest() {
        //2 Assert title Home Page
        homePage.checkPageTitle(HP_TITLE);

        //3 Log in to the system
        homePage.login(PITER);

        //4 Assert username
        homePage.checkUsername(PITER);

        //5 Open Dates page from Service from Navigation bar
        homePage.openServiceSubPage(DATES);

        //6 Using drag-and-drop set left to slider to min and right slider to max (from 0, to 100)
        datesPage.setSlidersValues(0,100);

        //7 Assert logs for 'From' and 'To' sliders
        datesPage.checkSlidersLogs(0, 100);

        //8 Using drag-and-drop set left to slider to min and right slider to min (from 0, to 0)
        datesPage.setSlidersValues(0, 0);

        //9 Assert logs for 'From' and 'To' sliders
        datesPage.checkSlidersLogs(0, 0);

        //10 Using drag-and-drop set left to slider to max and right slider to max (from 100, to 100)
        datesPage.setSlidersValues(100, 100);

        //11 Assert logs for 'From' and 'To' sliders
        datesPage.checkSlidersLogs(100, 100);

        //12 Using drag-and-drop set range sliders to the following values (from 30, to 70)
        datesPage.setSlidersValues(30, 70);

        //13 Assert logs for 'From' and 'To' sliders
        datesPage.checkSlidersLogs(30, 70);
    }
}
