package hw6.steps;

import hw6.enums.ServiceMenus;
import hw6.enums.SupportElements;
import hw6.enums.TableNames;
import hw6.enums.Users;
import hw6.pageObjects.DifferentElementsPage;
import hw6.pageObjects.HomePage;
import hw6.pageObjects.UserTablePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private HomePage homePage = page(HomePage.class);
    private DifferentElementsPage diffElemPage = page(DifferentElementsPage.class);
    private UserTablePage userTablePage = page(UserTablePage.class);

    @When("^I login as '([^\"]*)'$")
    public void iLoginAsPITER(Users exUser){
        homePage.login(exUser);
    }

    @When("^I click on 'Service' button in Heade$")
    public void ClickOnServiceMenuInTheHeader(){
        homePage.clickDropDownService();
    }

    @When("^I click on Service menu in the left section$")
    public void ClickOnServiceMenuInTheLeftSection(){
        homePage.clickLeftPanelService();
    }

    @When("^I click on 'Service' button in Header$")
    public void clickOnServiceButtonInHeader(){
        homePage.clickDropDownService();
    }

    @And("^I click on '([^\"]*)' button in Service dropdown$")
    public void navigateToServiceSubPage(ServiceMenus exDropDownOption){
        homePage.openServiceSubPage(exDropDownOption);
    }

    @When("^I select '([^\"]*)' checkbox$")
    public void tickCheckbox(SupportElements exCheckbox){
        diffElemPage.selectCheckbox(exCheckbox);
    }

    @When("^I select '([^\"]*)' radio button$")
    public void selectRadioButton(SupportElements element)  {
        diffElemPage.selectRadiobutton(element);
    }

    @When("^I select '([^\"]*)' dropdown value$")
    public void selectDropdownValue(SupportElements element) {
        diffElemPage.selectColor(element);
    }

    @When("^I deselect checkbox '([^\"]*)'$")
    public void untickCheckbox(SupportElements element) {
        diffElemPage.checkCheckboxDisabled(element);
    }

    @When("^I select 'vip' checkbox for '([^\"]*)'$")
    public void selectVipCheckbox(TableNames userName) {
        userTablePage.selectVipCheckbox(userName);
    }

    @When("^I click on dropdown in column Type for user Roman$")
    public void clickDropdownForRoman() {
        userTablePage.clickDropdownForRoman();
    }
}
