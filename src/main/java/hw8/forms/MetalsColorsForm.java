package hw8.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.base.HtmlRadioGroup;
import com.epam.jdi.light.ui.html.common.Button;
import hw8.entities.MetalsColors;
import hw8.entities.MetalsColorsFormData;

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

    @FindBy(css = "#submit-button")
    public Button submit;


    public void fillForm(MetalsColorsFormData data) {
        oddsSelector.select(String.valueOf(data.summary.get(0)));
        evenSelector.select(String.valueOf(data.summary.get(1)));
        for (String force : data.elements) {
            elements.select(force);
        }
        colors.select(data.color);
        metals.select(data.metals);
        vegetables.select(vegetables.getSelected());
        for (String vegetable : data.vegetables) {
            vegetables.select(vegetable);
        }
    }

    public void submitForm() {
        submit.click();
    }
}
