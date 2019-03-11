package hw4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static hw4.enums.Strings.LINK_CLICKED;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPage {

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all")
    private ElementsCollection dpSliders;

    @FindBy(css = ".panel-body-list.logs li")
    private ElementsCollection dpListLog;

    @FindBy(css = ".uui-slider")
    public SelenideElement sliderPanel;


    @Step("Drag&Drop sliders")
    public void setSlidersValues(int from, int to) {
        actions().clickAndHold(dpSliders.get(0))
                .moveToElement(sliderPanel, ((sliderPanel.getSize().width) * from / 100), 0)
                .release().build().perform();
        actions().clickAndHold(dpSliders.get(1))
                .moveToElement(sliderPanel, ((sliderPanel.getSize().width) * (to + 1) / 100), 0)
                .release().build().perform();
    }

    @Step("Check logs")
    public void checkSlidersLogs(int from, int to) {
        dpListLog.get(1).should(text(Integer.toString(from) + LINK_CLICKED.getValue()));
        dpListLog.get(0).should(text(Integer.toString(to) + LINK_CLICKED.getValue()));
    }

}
