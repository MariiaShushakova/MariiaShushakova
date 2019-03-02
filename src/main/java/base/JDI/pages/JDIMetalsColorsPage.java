package base.JDI.pages;

import base.JDI.entities.MetalsColors;
import base.JDI.forms.MetalsColorsForm;
import base.JDI.sections.ResultText;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Button;
import org.openqa.selenium.support.FindBy;

public class JDIMetalsColorsPage extends WebPage {

    @FindBy(css = "#submit-button")
    public Button submit;

    MetalsColorsForm form;
    ResultText result;

    public void fillForm(MetalsColors metalsColors) {
        form.fillForm(metalsColors);
    }

    public void submitForm() {
        submit.click();
    }

    public void checkForm(MetalsColors metalsColors) {
        result.checkLogPanel(metalsColors);
    }
}
