package base.JDI;

import HW4.enums.Users;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JDIHomePage {

    @FindBy(css = "[id='user-icon']")
    private WebElement profileButton;

    @FindBy(css = "[id='name']")
    private WebElement login;

    @FindBy(css = "[id='password']")
    private WebElement password;

    @FindBy(css = "[id='login-button']")
    private WebElement submit;

    public void login(Users user){
        profileButton.click();
        login.sendKeys(user.getLogin());
        password.sendKeys(user.getPassword());
        submit.click();
    }
}
