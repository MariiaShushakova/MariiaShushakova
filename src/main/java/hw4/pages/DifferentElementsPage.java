package hw4.pages;

import hw4.enums.SupportElements;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Check the elements at the DifferentElements page")
    public void checkElements() {
        depCheckbox.forEach(el -> el.shouldBe(visible));
        depCheckbox.shouldHaveSize(4);
        depRadioButton.forEach(el -> el.shouldBe(visible));
        depRadioButton.shouldHaveSize(4);
        depDropDown.shouldBe(visible);
        depButton.shouldBe(visible);
        depDefaultButton.shouldBe(visible);
    }

    @Step("Check that right section exists")
    public void checkRightSectionExists() {
        depRightSection.shouldBe(visible);
    }

    @Step("Check that right section exists")
    public void checkLeftSectionExists() {
        depLeftSection.shouldBe(visible);
    }

    @Step("Select checkboxes")
    public void selectCheckbox(SupportElements element) {
        SelenideElement checkbox = depCheckbox.stream().filter(box -> box.getText().equalsIgnoreCase(element.getValue())).findFirst().get();
        checkbox.click();
}

    @Step("Check checkboxes logs 'true'")
    public void checkCheckboxEnabled(SupportElements element) {
        depListLog.stream().filter(el -> el.getText().equals(element.getValue() + ": condition changed to true"));
    }

    @Step("Check checkboxes logs 'false'")
    public void checkCheckboxDisabled(SupportElements element) {
        depListLog.stream().filter(el -> el.getText().equals(element.getValue() + ": condition changed to false"));
    }

    @Step("Select radio button")
    public void selectRadiobutton(SupportElements metal) {
        SelenideElement radioControl = depRadioButton.stream().filter(el -> el.getText().equalsIgnoreCase(metal.getValue())).findFirst().get();
        radioControl.click();
    }

    @Step("Check radio button logs")
    public void checkRadioButtonLogs(SupportElements element) {
        depListLog.stream().filter(el -> el.getText().equals("metal: value changed to " + element.getValue()));
    }

    @Step("Select color")
    public void selectColor(SupportElements color) {
        depDropDown.selectOptionContainingText(color.getValue());
    }

    @Step("Select drop-down log")
    public void checkDropdownLogs(SupportElements color) {
        depListLog.stream().filter(el -> el.getText().equals("Colors: value changed to " + color.getValue()));


    }
}

