package base.JDI.forms;

import base.JDI.entities.MetalsColors;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.base.HtmlRadioGroup;
import com.epam.jdi.light.ui.html.common.Button;

public class MetalsColorsForm extends Form<MetalsColors> {

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    public static Droplist colors;

    @JDropdown(root = "div[ui=combobox]", value = "input", list = "li", expand = ".caret")
    public static Droplist metals;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    public static Droplist vegetables;

    @FindBy(css = "#elements-checklist p")
    public WebList elements;

    @FindBy(css = "#odds-selector")
    public HtmlRadioGroup oddsSelector;

    @FindBy(css = "#even-selector")
    public HtmlRadioGroup evenSelector;

    @FindBy(css = "#calculate-button")
    public Button calculateButton;


    public void fillForm(MetalsColors metalsColors) {
        oddsSelector.select(metalsColors.getOdd().toString());
        evenSelector.select(metalsColors.getEven().toString());
        calculateButton.click();
        metalsColors.getElement()
                .forEach(elem -> elements.select(elem));
        colors.select(metalsColors.getColor());
        metals.select(metalsColors.getMetal());
        vegetables.select(vegetables.getSelected());
        metalsColors.getVegetable()
                .forEach(elem -> vegetables.select(elem));
    }
}
