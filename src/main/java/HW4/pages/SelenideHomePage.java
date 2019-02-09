package HW4.pages;

import HW4.enums.ServiceMenu;
import HW4.enums.Titles;
import HW4.enums.Users;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.AssertJUnit.assertEquals;

public class SelenideHomePage {

    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "[id='user-name']")
    private SelenideElement usernameField;

    @FindBy(css = "[class='dropdown']")
    private SelenideElement dropDown;

    @FindBy(css = ".dropdown-menu li")
    private List<SelenideElement> dropDownMenu;

    @FindBy(css = "a[ui=label]")
    private SelenideElement leftService;

    @FindBy(css = "a[ui=label] + ul li")
    private List<SelenideElement> leftServiceMenu;

    @FindBy(css = ".dropdown-menu a[href*=different]")
    private SelenideElement differentElements;


    public void checkTitle(Titles hpTitle) {
        assertEquals(WebDriverRunner.getWebDriver().getTitle(), hpTitle.getValue());
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void checkUsername(Users user) {
        usernameField.should(visible);
        usernameField.should(text(user.getName()));
    }

    public void checkDropDownService(ServiceMenu[] value) {
        dropDown.click();
        for (int i = 0; i < dropDownMenu.size(); i++) {
            if (dropDownMenu.get(i).is(visible)) {
                dropDownMenu.get(i).shouldHave(text(value[i].getValue()));
            }
        }
    }

    public void checkLeftPanelService(ServiceMenu[] value) {
        leftService.click();
        for (int i = 0; i < leftServiceMenu.size(); i++) {
            if (leftServiceMenu.get(i).is(visible)) {
                leftServiceMenu.get(i).shouldHave(text(value[i].getValue()));
            }
        }
    }

    public void openServiceSubPage(String dropDownOption) {
        dropDown.click();
        switch (dropDownOption) {
            case "DIFFERENT ELEMENTS":
                differentElements.click();
                break;
            default:
                System.out.println("Invalid page");
                break;
        }

    }
}

