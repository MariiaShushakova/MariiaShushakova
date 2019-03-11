package hw3;

import hw3.enums.*;
// TODO Please do not forget delete unused imports - fixed
import hw4.enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage {
    private WebDriver driver;

    @FindBy(css = "[id='user-icon']")
    private WebElement profileButton;

    @FindBy(css = "[id='name']")
    private WebElement login;

    @FindBy(css = "[id='password']")
    private WebElement password;

    @FindBy(css = "[id='login-button']")
    private WebElement submit;

    @FindBy(css = "[id='user-name']")
    private WebElement userName;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']>li")
    // TODO Please do not forget delete commented lines - fixed
    private List<WebElement> topBar;

    @FindBy(css = "[class = 'benefit-icon']")
    private List<WebElement> image;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> text;

    @FindBy(css = "h3.main-title.text-center")
    private WebElement headerText1;

    @FindBy(css = "p.main-txt.text-center")
    private WebElement headerText2;

    @FindBy(css = "[id='iframe']")
    private WebElement iframe;

    @FindBy(css = "[id='epam_logo']")
    // TODO Please do not forget delete commented lines - fixed
    private WebElement logo;

    @FindBy(css = "a[ui='link']")
    // TODO Please do not forget delete commented lines - fixed
    private WebElement JDItitle;

    @FindBy(css = "div[name='navigation-sidebar']")
    // TODO Please do not forget delete commented lines - fixed
    private WebElement leftSection;

    @FindBy(css = "div[class='footer-bg']")
    // TODO Please do not forget delete commented lines - fixed
    private WebElement footer;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // TODO missing empty line between methods - fixed
    //open url
    public void open(Links url){
        driver.get(url.getValue());
    }

    // TODO missing empty line between methods - fixed
    //checkPageTitle
    public void checkTitle(Titles title){
        assertEquals(driver.getTitle(), title.getValue());
    }

    // TODO missing empty line between methods - fixed
    //login
    public void login(Users user){
        profileButton.click();
        login.sendKeys(user.getLogin());
        password.sendKeys(user.getPassword());
        submit.click();
    }

    // TODO missing empty line between methods fixed
    //check name
    public void checkUserName(Users user){
        assertEquals(userName.getText(), user.getName());
    }

    // TODO missing empty line between methods
    //check TopBar
    // TODO What does topBar mean? - topBar means navigation bar
    public void checkTopBar(){
        assertEquals(topBar.size(), 4);
        // TODO please do not forget use {} brace for for cycle body
        for (int i = 0; i < 4; i++) {
            assertTrue(topBar.get(i).isDisplayed());
        }

        assertEquals(topBar.get(0).getText(), TopBars.TOPBAR_HOME.getValue());
        assertEquals(topBar.get(1).getText(), TopBars.TOPBAR_CONTACT.getValue());
        assertEquals(topBar.get(2).getText(), TopBars.TOPBAR_SERVICE.getValue());
        assertEquals(topBar.get(3).getText(), TopBars.TOPBAR_METALS.getValue());
    }

    // TODO missing empty line between methods - fixed
    //check images
    // TODO What images do you check? - renamed method
    public void checkBenefitIcons(){
        assertEquals(image.size(), 4);
        // TODO please do not forget use {} brace for for cycle body
        for (int i = 0; i < 4; i++) {
            assertTrue(image.get(i).isDisplayed());
        }
    }

    // TODO missing empty line between methods
    //check texts
    // TODO What text do you check? Method name does not clear - renamed method
    public void checkBenefitTexts() {
        Assert.assertEquals(text.size(), 4);
        // TODO please do not forget use {} brace for for cycle body
        for (int i = 0; i < 4; i++) {
            assertTrue(text.get(i).isDisplayed());
        }

        assertEquals(text.get(0).getText(), Texts.TEXT_PRACTICE.getValue());
        assertEquals(text.get(1).getText(), Texts.TEXT_CUSTOM.getValue());
        assertEquals(text.get(2).getText(), Texts.TEXT_MULTI.getValue());
        assertEquals(text.get(3).getText(), Texts.TEXT_BASE.getValue());
    }

    // TODO missing empty line between methods - fixed
    //check Header Text
    public void checkHeaderText(){
        assertEquals(headerText1.getText(), TextHeaders.TEXT_HEADER_1.getValue());
        assertEquals(headerText2.getText(), TextHeaders.TEXT_HEADER_2.getValue());
    }

    // TODO missing empty line between methods - fixed
    //check iFrame
    public void checkiFrame(){
        assertTrue(iframe.isDisplayed());
    }

    // TODO missing empty line between methods - fixed
    //check logo
    // TODO This method name does not correlated with body
    public void checkLogo() {
        driver.switchTo().frame(iframe);
        assertTrue(logo.isDisplayed());
        // TODO Where is assertion? - fixed
    }

    // TODO missing empty line between methods - fixed
    //swich to the other iFrame
    // TODO missing space between (){ - fixed
    public void swtichFromIFrameToWindow() {
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().window(windowHandler);
    }

    // TODO missing empty line between methods - fixed
    //Check JDI Title
    public void titleJDI(){
        assertEquals(JDItitle.getText(), Titles.JDI_TITLE.getValue());
    }

    // TODO missing empty line between methods - fixed
    //check JDI link
    // TODO method name is not correlated with body - method renamed
    public void checkLinkJDI(){
        // TODO what is the purpose of the current assertion? - an attempt to check if element is a link
        // or not
        assertEquals(JDItitle.getTagName(), Links.HP_LINK_TAG.getValue());
        assertEquals(JDItitle.getAttribute("href"), Links.HP_JDI.getValue());

    }

    // TODO missing empty line between methods - fixed
    // left section
    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    // TODO missing empty line between methods - fixed
    //footer
    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }

}
