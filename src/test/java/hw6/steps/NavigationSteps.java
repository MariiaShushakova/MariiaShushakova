package hw6.steps;

import HW4.pages.HomePage;
import cucumber.api.java.en.Given;

import static HW4.enums.Links.HP_LINK;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class NavigationSteps {
    private HomePage homePage;

    @Given("^I open EPAM JDI site$")
    public void openEPAMJDISite() {
        open(HP_LINK.getValue());
        homePage = page(HomePage.class);
    }
}
