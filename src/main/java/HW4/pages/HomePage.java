package HW4.pages;

import HW4.enums.ServiceMenus;
import HW4.enums.Titles;
import HW4.enums.Users;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage {

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
    private ElementsCollection leftPanelServiceMenu;

    @FindBy(css = ".dropdown-menu a[href*=different]")
    private SelenideElement differentElementsOption;

    @FindBy(css = ".dropdown-menu a[href*=dates]")
    private SelenideElement datesOption;


    public void checkPageTitle(Titles hpTitle) {
        assertEquals(getWebDriver().getTitle(), hpTitle.getValue());
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

    public void checkMenuItems(ElementsCollection list, ServiceMenus[] value) {
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).toString().contains(value[i].toString())) {
                    list.get(j).shouldBe(visible);
                    list.get(j).shouldHave(text(value[i].toString()));
                }
            }
        }
    }

    //TODO: you can make this two methods checkDropDownService and checkLeftPanelService - Done
    //to use one common method with income parameters e.g. checkMenuItems(List<SelenideElements>, ServiceMenus)
    public void checkDropDownService(ServiceMenus[] value) {
        dropdown.click();
        checkMenuItems(dropdownMenu, value);
    }

    public void checkLeftPanelService(ServiceMenus[] value) {
        leftPanelService.click();
        checkMenuItems(leftPanelServiceMenu, value);
    }

    public void openServiceSubPage(ServiceMenus dropDownOption) {
        dropdown.click();
        switch (dropDownOption.getValue()) {
            case "DIFFERENT ELEMENTS":
                differentElementsOption.click();
                break;
            case "DATES":
                datesOption.click();
                break;
            default:
                System.out.println("Invalid page");
                break;
        }
    }
}
