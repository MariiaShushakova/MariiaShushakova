package hw6;

import HW4.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

import static HW4.enums.Links.HP_LINK;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;

public class NavigationSteps {
    private HomePage homePage;

    @Given("^I open EPAM JDI site$")
    public void iOpenEPAMJDISite() {
        open(HP_LINK.getValue());
        homePage = page(HomePage.class);
    }
}
