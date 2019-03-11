package hw8.pages;

import hw8.entities.User;
import hw8.enums.Navigation;
import hw8.forms.LoginForm;
import hw8.sections.Header;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import org.openqa.selenium.support.FindBy;

import static hw8.JDISite.metalsColorsPage;


public class JDIHomePage extends WebPage {
    public LoginForm loginForm;
    public Header header;


    @FindBy(css = "#user-icon")
    private Icon profileButton;

    public void login(User user){
        profileButton.click();
        loginForm.login(user);
    }

    public void openMenu(Navigation item){
        header.navigationBar.select(item.getValue());
        metalsColorsPage.shouldBeOpened();
    }

}
