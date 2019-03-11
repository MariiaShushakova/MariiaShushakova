package hw6.steps;

import hw6.enums.*;
import hw6.pageObjects.DifferentElementsPage;
import hw6.pageObjects.HomePage;
import hw6.pageObjects.UserTablePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    private HomePage homePage = page(HomePage.class);
    private DifferentElementsPage diffElemPage = page(DifferentElementsPage.class);
    private UserTablePage userTablePage = page(UserTablePage.class);

    @Then("^'([^\"]*)' page is opened$")
    public void browserTitleShouldBeHomePage(Titles exTitle){
        homePage.checkPageTitle(exTitle);
    }

    @Then("^Username should be '([^\"]*)'$")
    public void checkUsernameIsCorrect(Users exUser){
        homePage.checkUsername(exUser);
    }

    @Then("^Home Page should have 4 benefit icons$")
    public void homePageIconsCheck(){
        homePage.checkBenefitIcons();
    }

    @Then("^Home Page should have 4 texts under icons$")
    public void homePageTextsUnderIconsCheck(){
        homePage.checkBenefitTexts();
    }

    @Then("^Home Page should have title '([^\"]*)' and description '([^\"]*)'$")
    public void homePageTitleAndDescription(TextHeaders exTextHeader1, TextHeaders exTextHeader2){
        homePage.checkHeaderText(exTextHeader1, exTextHeader2);
    }

    @Then("^Service dropdown menu contains options:$")
    public void serviceDropdownMenuContainsOptions(List<ServiceMenus> list){
        ServiceMenus[] arr = list.toArray(new ServiceMenus[0]);
        homePage.checkDropDownService(arr);
    }

    @Then("^Service dropdown in left section contains options:$")
    public void serviceDropdownInLeftSectionContainsOptions(List<ServiceMenus> list){
        ServiceMenus[] arr = list.toArray(new ServiceMenus[0]);
        homePage.checkLeftPanelService(arr);
    }

    @Then("^Different elements page contains elements$")
    public void diffElementsPageContainsCheckboxes(){
        diffElemPage.checkElements();
        diffElemPage.checkRightSectionExists();
        diffElemPage.checkLeftSectionExists();
    }

    @Then("^Log row for enabling '([^\"]*)' checkbox appears")
    public void checkCheckboxEnabled(SupportElements element) {
        diffElemPage.checkCheckboxEnabled(element);
    }

    @Then("^Log row for '([^\"]*)' radiobutton appears$")
    public void checkLogForRadioButton(SupportElements element) {
        diffElemPage.checkRadioButtonLogs(element);
    }

    @Then("^Log row for '([^\"]*)' value appears$")
    public void checkLogForDropdown(SupportElements element) {
        diffElemPage.checkDropdownLogs(element);
    }

    @Then("^The deselection of '([^\"]*)' is logged$")
    public void checkCheckboxDisabled(SupportElements element) {
        diffElemPage.checkCheckboxDisabled(element);
    }

    @And("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numbertypeDropdownsAreDisplayed(int dropdownsCount){
        userTablePage.checkDropdownsCount(dropdownsCount);
    }

    @And("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void checkUserNames(int namesCount) {
        userTablePage.checkNames(namesCount);
    }

    @And("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void checkImages(int imagesCount) {
        userTablePage.checkImages(imagesCount);
    }

    @And("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void checkTexts(int textsCount) {
        userTablePage.checkTexts(textsCount);
    }

    @And("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUsersTableOnUserTablePage(int checkboxesCount) {
        userTablePage.checkCheckboxes(checkboxesCount);
    }

    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(DataTable dataTable) {
       userTablePage.checkUserTableValues(dataTable);
    }

    @Then("^(\\d+) log row has '([^\"]*)' text in log section$")
    public void checkLogInTextSection(int logCount, String text) {
        userTablePage.logRowHasTextInLogSection(logCount, text);
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(List<String> values) {
        userTablePage.checkDropdownHasValues(values);
    }
}