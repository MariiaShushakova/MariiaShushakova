package hw4;

import hw4.enums.ServiceMenus;
import hw4.pages.DifferentElementsPage;
import hw4.pages.HomePage;
import base.SelenideBase;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw4.enums.Links.HP_LINK;
import static hw4.enums.ServiceMenus.DIFFERENT_ELEMENTS;
import static hw4.enums.SupportElements.*;
import static hw4.enums.Titles.HP_TITLE;
import static hw4.enums.Users.PITER;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;

public class ServicePageTest extends SelenideBase {
    private HomePage homePage;
    private DifferentElementsPage diffElemPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test url
        Selenide.open(HP_LINK.getValue());
        homePage = page(HomePage.class);
        diffElemPage = page(DifferentElementsPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        // Close web driver
        close();
    }

    @Test
    public void differentElementsPageTest() {
        //2 Assert title Home Page
        //TODO: rename checkPageTitle - DONE
        homePage.checkPageTitle(HP_TITLE);

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
        diffElemPage.selectCheckbox(CHECKBOX_WATER);
        diffElemPage.selectCheckbox(CHECKBOX_WIND);

        //12 Assert checkboxes logs
        diffElemPage.checkCheckboxEnabled(CHECKBOX_WATER);
        diffElemPage.checkCheckboxEnabled(CHECKBOX_WIND);

        //13 Select 'Selen' radio button
        diffElemPage.selectRadiobutton(RADIO_BUTTON_SELEN);

        //14 Assert radio button log
        diffElemPage.checkRadioButtonLogs(RADIO_BUTTON_SELEN);

        //15 Select 'Yellow' color
        diffElemPage.selectColor(DROPDOWN_YELLOW);

        //16 Assert dropdown values log
        diffElemPage.checkDropdownLogs(DROPDOWN_YELLOW);

        //17 Deselect 'Water' and 'Wind' checkboxes
        diffElemPage.selectCheckbox(CHECKBOX_WATER);
        diffElemPage.selectCheckbox(CHECKBOX_WIND);

        //18 Assert logs for deselected checkboxes
        diffElemPage.checkCheckboxDisabled(CHECKBOX_WATER);
        diffElemPage.checkCheckboxDisabled(CHECKBOX_WIND);
    }
}
