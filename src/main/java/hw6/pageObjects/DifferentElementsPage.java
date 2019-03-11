package hw6.pageObjects;

import hw6.enums.SupportElements;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class DifferentElementsPage {
    @FindBy(css = ".label-checkbox")
    private ElementsCollection depCheckbox;

    @FindBy(css = ".label-radio")
    private ElementsCollection depRadioButton;

    @FindBy(css = ".colors select")
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
        depCheckbox.forEach(el -> el.shouldBe(visible));
        depCheckbox.shouldHaveSize(4);
        depRadioButton.forEach(el -> el.shouldBe(visible));
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

    public void selectCheckbox(SupportElements element) {
        SelenideElement checkbox = depCheckbox.stream().filter(box -> box.getText().equalsIgnoreCase(element.getValue())).findFirst().get();
        checkbox.click();
}

    public void checkCheckboxEnabled(SupportElements element) {
        depListLog.stream().filter(el -> el.getText().equals(element.getValue() + ": condition changed to true"));
    }

    public void checkCheckboxDisabled(SupportElements element) {
        depListLog.stream().filter(el -> el.getText().equals(element.getValue() + ": condition changed to false"));
    }

    public void selectRadiobutton(SupportElements metal) {
        SelenideElement radioControl = depRadioButton.stream().filter(el -> el.getText().equalsIgnoreCase(metal.getValue())).findFirst().get();
        radioControl.click();
    }

    public void checkRadioButtonLogs(SupportElements element) {
        depListLog.stream().filter(el -> el.getText().equals("metal: value changed to " + element.getValue()));
    }

    public void selectColor(SupportElements color) {
        depDropDown.selectOptionContainingText(color.getValue());
    }

    public void checkDropdownLogs(SupportElements color) {
        depListLog.stream().filter(el -> el.getText().equals("Colors: value changed to " + color.getValue()));
    }
}

