package hw8.pages;

import hw8.entities.MetalsColorsFormData;
import hw8.forms.MetalsColorsForm;
import hw8.sections.ResultText;
import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static hw8.entities.MetalsColorsFormData.listToStringWithoutBrackets;
import static org.testng.Assert.assertEquals;

public class JDIMetalsColorsPage extends WebPage {

    @Css(".results > li")
    private WebList results;

    public MetalsColorsForm form;
    ResultText result;





    public void checkResult(MetalsColorsFormData data) {
        List<String> actual = results.stream().map(BaseUIElement::getText).collect(Collectors.toList());
        List<String> expected = Arrays.asList(
                "Summary: " + (data.summary.get(0) + data.summary.get(1)),
                "Elements: " + listToStringWithoutBrackets(data.elements),
                "Color: " + data.color,
                "Metal: " + data.metals,
                "Vegetables: " + listToStringWithoutBrackets(data.vegetables));
        assertEquals(expected, actual);
    }
}
