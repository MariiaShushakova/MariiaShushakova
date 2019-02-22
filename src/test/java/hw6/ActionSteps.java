package hw6;

import HW6.enums.Users;
import HW6.pagePbjects.HomePage;
import cucumber.api.java.en.When;
import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private HomePage homePage = page(HomePage.class);

    @When("^I login as '([^\"]*)'$")
    public void iLoginAsPITER(Users exUser){
        homePage.login(exUser);
    }
}
