package hw8;

import hw8.pages.JDIHomePage;
import hw8.pages.JDIMetalsColorsPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://epam.github.io/JDI/")
public class JDISite {

    @Url("index.html")
    public static JDIHomePage jdiHomePage;

    @Url("metals-colors.html")
    public static JDIMetalsColorsPage metalsColorsPage;
}
