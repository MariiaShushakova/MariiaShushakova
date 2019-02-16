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
        //TODO: use streams e.g. depCheckbox.forEach(el -> el.shouldBe(visible)); - Done
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
        //TODO use foreach or streams - Done
        SelenideElement checkbox = depCheckbox.stream().filter(box -> box.getText().equalsIgnoreCase(element.getValue())).findFirst().get();
        checkbox.click();
}

    public void checkCheckboxEnabled(SupportElements element) {
        //TODO use foreach or streams - Done
        depListLog.stream().filter(el -> el.getText().equals(element.getValue() + ": condition changed to true"));

    }

    public void checkCheckboxDisabled(SupportElements element) {
        depListLog.stream().filter(el -> el.getText().equals(element.getValue() + ": condition changed to false"));

    }

    public void selectRadiobutton(SupportElements metal) {
        //TODO use foreach or streams - Done
        SelenideElement radioControl = depRadioButton.stream().filter(el -> el.getText().equalsIgnoreCase(metal.getValue())).findFirst().get();
        radioControl.click();
    }

    public void checkRadioButtonLogs(SupportElements element) {
        //TODO use foreach or streams - Done
        depListLog.stream().filter(el -> el.getText().equals("metal: value changed to " + element.getValue()));
    }

    public void selectColor(SupportElements color) {
        depDropDown.selectOptionContainingText(color.getValue());
    }

    public void checkDropdownLogs(SupportElements color) {
        //TODO use foreach or streams - Done
        depListLog.stream().filter(el -> el.getText().equals("Colors: value changed to " + color.getValue()));


    }
}

