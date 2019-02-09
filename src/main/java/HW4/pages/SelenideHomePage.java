package HW4.pages;

import HW4.enums.ServiceMenu;
import HW4.enums.Titles;
import HW4.enums.Users;
import com.codeborne.selenide.ElementsCollection;
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
    private SelenideElement dropdown;

    @FindBy(css = ".dropdown-menu li")
    private ElementsCollection dropdownMenu;

    @FindBy(css = "a[ui=label]")
    private SelenideElement leftPanelService;

    @FindBy(css = "a[ui=label] + ul li")
    private List<SelenideElement> leftPanelServiceMenu;

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
        dropdown.click();
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < dropdownMenu.size(); j++) {
                if (dropdownMenu.get(j).toString().contains(value[i].toString())) {
                    dropdownMenu.get(j).shouldBe(visible);
                    dropdownMenu.get(j).shouldHave(text(value[i].toString()));
                }
            }
        }
    }

    public void checkLeftPanelService(ServiceMenu[] value) {
        leftPanelService.click();
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < leftPanelServiceMenu.size(); j++) {
                if (leftPanelServiceMenu.get(j).toString().contains(value[i].toString())) {
                    leftPanelServiceMenu.get(j).shouldBe(visible);
                    leftPanelServiceMenu.get(j).shouldHave(text(value[i].toString()));
                }
            }
        }
    }

    public void openServiceSubPage(String dropDownOption) {
        dropdown.click();
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

