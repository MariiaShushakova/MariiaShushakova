package base.JDI.pages;

import base.JDI.entities.User;
import base.JDI.enums.Navigation;
import base.JDI.forms.LoginForm;
import base.JDI.sections.Header;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import org.openqa.selenium.support.FindBy;
import static base.JDI.JDISite.metalsColorsPage;

public class JDIHomePage extends WebPage {
    public LoginForm loginForm;
    public Header header;


    @FindBy(css = "[id='user-icon']")
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
