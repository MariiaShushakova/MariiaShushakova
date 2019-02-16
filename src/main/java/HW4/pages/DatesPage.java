package HW4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static HW4.enums.Strings.LINK_CLICKED;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPage {

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all")
    private ElementsCollection dpSliders;

    @FindBy(css = ".panel-body-list.logs li")
    private ElementsCollection dpListLog;

    @FindBy(css = ".uui-slider")
    public SelenideElement sliderPanel;

    //TODO method sometimes sets incorrect position for 30/70 values - it worked 5 of 5 times for me
    public void setSlidersValues(int from, int to) {
        actions().clickAndHold(dpSliders.get(0))
                .moveToElement(sliderPanel, ((sliderPanel.getSize().width) * from / 100), 0)
                .release().build().perform();
        actions().clickAndHold(dpSliders.get(1))
                .moveToElement(sliderPanel, ((sliderPanel.getSize().width) * (to + 1) / 100), 0)
                .release().build().perform();
    }

    //TODO avoid to use get(index) in code; use "for" to check if log contains correct message -? ;(
    //MOVE "link clicked" to constant - Done
    public void checkSlidersLogs(int from, int to) {
        dpListLog.get(1).should(text(Integer.toString(from) + LINK_CLICKED.getValue()));
        dpListLog.get(0).should(text(Integer.toString(to) + LINK_CLICKED.getValue()));
    }

}
