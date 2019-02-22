package hw6;

import HW6.enums.Titles;
import HW6.enums.Users;
import HW6.pagePbjects.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    private HomePage homePage = page(HomePage.class);

    @Then("^Browser title should be '([^\"]*)'$")
    public void browserTitleShouldBeHomePage(Titles exTitle){
        homePage.checkPageTitle(exTitle);
    }

    @Then("^Username should be '([^\"]*)'$")
    public void usernameShouldBePITER(Users exUser){
        homePage.checkUsername(exUser);
    }

    @Then("^Home Page should have (\\d+) benefit icons$")
    public void homePageShouldHaveBenefitIcons(int arg0){
        homePage.checkBenefitIcons();
    }
}