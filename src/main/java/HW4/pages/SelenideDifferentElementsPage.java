package HW4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;

public class SelenideDifferentElementsPage {
    @FindBy(css = ".label-checkbox")
    private ElementsCollection depCheckbox;

    @FindBy(css = ".label-radio")
    private ElementsCollection depRadioButton;

    @FindBy(css = ".colors")
    private SelenideElement depDropDown;

    @FindBy(css = "button[class=uui-button]")
    private SelenideElement depButton;

    @FindBy(css = "input[class=uui-button]")
    private SelenideElement depDefaultButton;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement depRightSection;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement depLeftSection;

    @FindBy(css = ".panel-body-list.logs li")
    private ElementsCollection depListLog;

    @FindBy(css = ".uui-form-element option")
    private ElementsCollection depColors;

    public void checkElements() {
        for (int i = 0; i < depCheckbox.size(); i++) {
            depCheckbox.get(i).shouldBe(visible);
        }
        depCheckbox.shouldHaveSize(4);

        for (int i =0; i < depRadioButton.size(); i++) {
            depRadioButton.get(i).shouldBe(visible);
        }
        depRadioButton.shouldHaveSize(4);

        depDropDown.shouldBe(visible);
        depButton.shouldBe(visible);
        depDefaultButton.shouldBe(visible);
    }

    public void checkRightSectionExists() {
        depRightSection.shouldBe(visible);
    }

    public void checkLeftSectionExists() {
        depLeftSection.shouldBe(visible);
    }

    public void selectCheckboxesTODO(List<String> values) {
        for (int i = 0; i < depCheckbox.size(); i++) {
           if (values.contains(depCheckbox.get(i).getText())) {
               depCheckbox.get(i).click();
           }
        }
    }

    public void selectCheckboxes(String value1, String value2) {
        for (int i = 0; i < depCheckbox.size(); i++) {
            if (depCheckbox.get(i).getText().equals(value1) || depCheckbox.get(i).getText().equals(value2)) {
                depCheckbox.get(i).click();
            }
        }
    }

    public void checkCheckboxesLogs(String state) {
        for (int i = 0; i < depCheckbox.size(); i++) {
            switch (depCheckbox.get(i).getText()) {
                case "Water":
                    depListLog.get(i).getText().contains("Water: condition changed to " + state);
                    break;
                case "Earth":
                    depListLog.get(i).getText().contains("Earth: condition changed to " + state);
                    break;
                case "Wind":
                    depListLog.get(i).getText().contains("Wind: condition changed to "  + state);
                    break;
                case "Fire":
                    depListLog.get(i).getText().contains("Fire: condition changed to "  + state);
                    break;
                default:
                    System.out.println("Unexpected log record");
                    break;
            }
        }
    }

    public void selectRadiobuttons(String value) {
        for (int i = 0; i < depRadioButton.size(); i++) {
            if (depRadioButton.get(i).getText().equals(value)) {
                depRadioButton.get(i).click();
            }
        }
    }

    public void checkRadioButtonLogs() {
        for (int i = 0; i < depRadioButton.size(); i++) {
            depRadioButton.get(i).click();
            depListLog.get(i).getText().contains("metal: value changed to " + depRadioButton.get(i).getText());
        }
    }

    public void selectColor(String color) {
        depDropDown.click();
        for (int i = 0; i < depColors.size(); i++) {
            if (depColors.get(i).getText().equals(color)) {
                depColors.get(i).click();
            }
        }
    }

    public void checkDropdownLogs() {
        depDropDown.click();
        for (int i = 0; i < depColors.size(); i++) {
            depColors.get(i).click();
            depListLog.get(i).getText().contains("Colors: value changed to " + depColors.get(i).getText());
        }
    }
}

