package hw4;

import HW4.enums.ServiceMenu;
import HW4.enums.Titles;
import HW4.enums.Users;
import HW4.pages.SelenideDifferentElementsPage;
import HW4.pages.SelenideHomePage;
import base.SelenideBase;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static HW4.enums.ServiceMenu.DIFFERENT_ELEMENTS;
import static HW4.enums.SupportElements.*;
import static com.codeborne.selenide.Selenide.page;

public class ServicePageTest extends SelenideBase {
    private SelenideHomePage homePage;
    private SelenideDifferentElementsPage diffElemPage;
    // List<String> list = [SupportElements.CHECKBOX_WATER.getValue(), SupportElements.CHECKBOX_WIND.getValue()];

    @BeforeMethod
    public void beforeMethod() {
        Selenide.open(HW4.enums.Links.HP_LINK.getValue());
        homePage = page(SelenideHomePage.class);
    }

    @Test
    public void differentElementsPageTest() {
        //1 Assert title Home Page
        homePage.checkTitle(Titles.HP_TITLE);

        //2 Log in to the system
        homePage.login(Users.PITER);

        //3 Assert username
        homePage.checkUsername(Users.PITER);

        //4 Check Service menu values from the Navigation bar
        homePage.checkDropDownService(ServiceMenu.values());

        //5 Check Service menu values from the Left Panel
        homePage.checkLeftPanelService(ServiceMenu.values());

        //6 Go to DifferentElements page from the Navigation bar
        diffElemPage = page(SelenideDifferentElementsPage.class);
        homePage.openServiceSubPage(DIFFERENT_ELEMENTS.getValue());

        //7 Check the elements at the DifferentElements page
        diffElemPage.checkElements();

        //8 Assert Right Section exists at the DifferentElements page
        diffElemPage.checkRightSectionExists();

        //9 Assert Left Section exists at the DifferentElements page
        diffElemPage.checkLeftSectionExists();

        //10 Select 'Water' and 'Wind' checkboxes
        diffElemPage.selectCheckboxes(CHECKBOX_WATER.getValue(), CHECKBOX_WIND.getValue());

        //11 Assert checkboxes logs
        diffElemPage.checkCheckboxesLogs("true");

        //12 Select 'Selen' radio button
        diffElemPage.selectRadiobuttons(RADIO_BUTTON_SELEN.getValue());

        //13 Assert radio button log
        diffElemPage.checkRadioButtonLogs();

        //14 Select 'Yellow' color
        diffElemPage.selectColor(DROPDOWN_YELLOW.getValue());

        //15 Assert dropdown values log
        diffElemPage.checkDropdownLogs();

        //16 Deselect 'Water' and 'Wind' checkboxes and assert logs
        diffElemPage.selectCheckboxes(CHECKBOX_WATER.getValue(), CHECKBOX_WIND.getValue());
        diffElemPage.checkCheckboxesLogs("false");

    }

}
