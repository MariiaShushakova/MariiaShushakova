package HW4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPage {

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all")
    private ElementsCollection dpSlider;

    @FindBy(css = ".panel-body-list.logs li")
    private ElementsCollection dpListLog;

    @FindBy(css = ".uui-slider")
    public SelenideElement sliderPanel;

    public void setSlidersValues(int from, int to) {
        actions().clickAndHold(dpSlider.get(0))
                .moveToElement(sliderPanel, ((sliderPanel.getSize().width) * (from)/100 ),0)
                .release().build().perform();
        actions().clickAndHold(dpSlider.get(1))
                .moveToElement(sliderPanel, ((sliderPanel.getSize().width) * (to + 1)/100), 0)
                .release().build().perform();
    }

    public void checkSlidersLogs(int from, int to) {
        dpListLog.get(1).should(text(Integer.toString(from) + " link clicked"));
        dpListLog.get(0).should(text(Integer.toString(to) + " link clicked"));
    }

}
