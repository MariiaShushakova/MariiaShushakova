package hw6.pageObjects;

import hw6.enums.TextHeaders;
import hw6.enums.Texts;
import hw6.enums.ServiceMenus;
import hw6.enums.Titles;
import hw6.enums.Users;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertTrue;
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

    @FindBy(css = ".dropdown-menu a[href*=user-table]")
    private SelenideElement userTableOption;

    @FindBy(css = "[class = 'benefit-icon']")
    private ElementsCollection image;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection text;

    @FindBy(css = "h3.main-title.text-center")
    private SelenideElement headerText1;

    @FindBy(css = "p.main-txt.text-center")
    private SelenideElement headerText2;


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

    public void checkBenefitIcons(){
        assertEquals(image.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(image.get(i).isDisplayed());
        }
    }

    public void checkBenefitTexts() {
        Assert.assertEquals(text.size(), 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(text.get(i).isDisplayed());
        }

        assertEquals(text.get(0).getText(), Texts.TEXT_PRACTICE.getValue());
        assertEquals(text.get(1).getText(), Texts.TEXT_CUSTOM.getValue());
        assertEquals(text.get(2).getText(), Texts.TEXT_MULTI.getValue());
        assertEquals(text.get(3).getText(), Texts.TEXT_BASE.getValue());
    }


    public void checkHeaderText(TextHeaders textHeader1, TextHeaders textHeader2){
        assertEquals(headerText1.getText(), textHeader1.getValue());
        assertEquals(headerText2.getText(), textHeader2.getValue());
    }

    public void clickDropDownService(){
        dropdown.click();
    }

    public void checkMenuItems(ElementsCollection list, ServiceMenus[] value) {
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).toString().contains(value[i].getValue())) {
                    list.get(j).shouldBe(visible);
                    list.get(j).shouldHave(text(value[i].getValue()));
                }
            }
        }
    }

    public void checkDropDownService(ServiceMenus[] value) {
        checkMenuItems(dropdownMenu, value);
    }

    public void clickLeftPanelService(){
        leftPanelService.click();
    }

    public void checkLeftPanelService(ServiceMenus[] value) {
        checkMenuItems(leftPanelServiceMenu, value);
    }

    public void openServiceSubPage(ServiceMenus dropDownOption) {
        switch (dropDownOption.getValue()) {
            case "DIFFERENT ELEMENTS":
                differentElementsOption.click();
                break;
            case "DATES":
                datesOption.click();
                break;
            case "USER TABLE":
                userTableOption.click();
                break;
            default:
                System.out.println("Invalid page");
                break;
        }
    }
}

