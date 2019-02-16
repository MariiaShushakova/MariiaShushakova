package hw4;

import HW4.enums.ServiceMenus;
import HW4.pages.DatesPage;
import HW4.pages.DifferentElementsPage;
import HW4.pages.HomePage;
import base.SelenideBase;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static HW4.enums.Links.HP_LINK;
import static HW4.enums.ServiceMenus.DATES;
import static HW4.enums.ServiceMenus.DIFFERENT_ELEMENTS;
import static HW4.enums.SupportElements.*;
import static HW4.enums.Titles.HP_TITLE;
import static HW4.enums.Users.PITER;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;

public class ServicePageTest extends SelenideBase {
    private HomePage homePage;
    private DifferentElementsPage diffElemPage;
    private DatesPage datesPage;


    @BeforeMethod
    public void beforeMethod() {
        //1 Open test url
        Selenide.open(HP_LINK.getValue());
        homePage = page(HomePage.class);
        diffElemPage = page(DifferentElementsPage.class);
        datesPage = page(DatesPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        // Close web driver
        close();
    }


    // exercise 1
    @Test
    public void differentElementsPageTest() {
        //2 Assert title Home Page
        //TODO: rename checkPageTitle
        homePage.checkTitle(HP_TITLE);

        //3 Log in to the system
        homePage.login(PITER);

        //4 Assert username
        homePage.checkUsername(PITER);

        //5 Check Service menu values from the Navigation bar
        homePage.checkDropDownService(ServiceMenus.values());

        //6 Check Service menu values from the Left Panel
        homePage.checkLeftPanelService(ServiceMenus.values());

        //7 Go to DifferentElements page from the Navigation bar
        homePage.openServiceSubPage(DIFFERENT_ELEMENTS);

        //8 Check the elements at the DifferentElements page
        diffElemPage.checkElements();

        //9 Assert Right Section exists at the DifferentElements page
        diffElemPage.checkRightSectionExists();

        //10 Assert Left Section exists at the DifferentElements page
        diffElemPage.checkLeftSectionExists();

        //11 Select 'Water' and 'Wind' checkboxes
        diffElemPage.selectCheckboxes(CHECKBOX_WATER, CHECKBOX_WIND);

        //12 Assert checkboxes logs
        diffElemPage.checkCheckboxesLogs("true");

        //13 Select 'Selen' radio button
        diffElemPage.selectRadiobuttons(RADIO_BUTTON_SELEN);

        //14 Assert radio button log
        diffElemPage.checkRadioButtonLogs();

        //15 Select 'Yellow' color
        diffElemPage.selectColor(DROPDOWN_YELLOW);

        //16 Assert dropdown values log
        diffElemPage.checkDropdownLogs();

        //17 Deselect 'Water' and 'Wind' checkboxes
        diffElemPage.selectCheckboxes(CHECKBOX_WATER, CHECKBOX_WIND);

        //18 Assert logs for deselected checkboxes
        diffElemPage.checkCheckboxesLogs("false");

    }

    // exercise 2
    //TODO move test to separate file
    //Test fails each time when I run it
    @Test
    public void datesPageTest() {
        //2 Assert title Home Page
        homePage.checkTitle(HP_TITLE);

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
