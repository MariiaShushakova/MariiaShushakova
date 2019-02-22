package hw6.steps;

import HW6.enums.Titles;
import HW6.enums.Users;
import HW6.pagePbjects.HomePage;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    private HomePage homePage = page(HomePage.class);

    @Then("^Browser title should be '([^\"]*)'$")
    public void browserTitleShouldBeHomePage(Titles exTitle){
        homePage.checkPageTitle(exTitle);
    }

    @Then("^Username should be '([^\"]*)'$")
    public void checkUsernameIsCorrect(Users exUser){
        homePage.checkUsername(exUser);
    }

    @Then("^Home Page should have (\\d+) benefit icons$")
    public void homePageIconsCheck(int arg0){
        homePage.checkBenefitIcons();
    }
}