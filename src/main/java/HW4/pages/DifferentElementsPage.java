package HW4.pages;

import HW4.enums.SupportElements;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class DifferentElementsPage {
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
        //TODO: use streams e.g. depCheckbox.forEach(el -> el.shouldBe(visible));
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

    public void selectCheckboxes(SupportElements element1, SupportElements element2) {
        //TODO use foreach or streams
        for (int i = 0; i < depCheckbox.size(); i++) {
            if (depCheckbox.get(i).getText().equals(element1.getValue()) ||
                    depCheckbox.get(i).getText().equals(element2.getValue())) {
                depCheckbox.get(i).click();
            }
        }
    }

    public void checkCheckboxesLogs(String state) {
        //TODO use foreach or streams
        for (int i = 0; i < depCheckbox.size(); i++) {
            switch (depCheckbox.get(i).getText()) {
                case "Water":
                    //TODO where the assert?
                    depListLog.get(0).getText().contains("Water: condition changed to " + state);
                    break;
                case "Wind":
                    //TODO where the assert?
                    depListLog.get(0).getText().contains("Wind: condition changed to "  + state);
                    break;
                default:
                    break;
            }
        }
    }

    public void selectRadiobuttons(SupportElements metal) {
        //TODO use foreach or streams
        for (int i = 0; i < depRadioButton.size(); i++) {
            if (depRadioButton.get(i).getText().equals(metal.getValue())) {
                depRadioButton.get(i).click();
            }
        }
    }

    public void checkRadioButtonLogs() {
        //TODO use foreach or streams
        for (int i = 0; i < depRadioButton.size(); i++) {
            depRadioButton.get(i).click();
            //TODO where the assert?
            depListLog.get(i).getText().contains("metal: value changed to " + depRadioButton.get(i).getText());
        }
    }

    public void selectColor(SupportElements color) {
        depDropDown.click();
        //TODO use foreach or streams
        for (int i = 0; i < depColors.size(); i++) {
            if (depColors.get(i).getText().equals(color.getValue())) {
                depColors.get(i).click();
            }
        }
    }

    public void checkDropdownLogs() {
        depDropDown.click();
        //TODO use foreach or streams
        for (int i = 0; i < depColors.size(); i++) {
            depColors.get(i).click();
            //TODO where the assert?
            depListLog.get(i).getText().contains("Colors: value changed to " + depColors.get(i).getText());
        }
    }
}

