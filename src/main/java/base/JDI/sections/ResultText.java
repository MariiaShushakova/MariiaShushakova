package base.JDI.sections;

import base.JDI.entities.MetalsColors;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResultText extends Section {
    @FindBy(className = "results")
    public WebList resultText;

    public void checkLogPanel(MetalsColors params) {
        List<String> resultContent = new ArrayList<>();
        for (WebElement element : resultText) {
            resultContent.add(element.getText());
        }

        assertTrue(resultContent.contains("Summary: " + (params.getOdd() + params.getEven())));
        assertTrue(resultContent.contains("Elements: " + String.join(", ", params.getElement())));
        assertTrue(resultContent.contains("Color: " + params.getColor()));
        assertTrue(resultContent.contains("Metal: " + params.getMetal()));
        assertTrue(resultContent.contains("Vegetables: " + String.join(", ", params.getVegetable())));
    }
}
