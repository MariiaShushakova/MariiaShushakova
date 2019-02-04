package HW3;

import HW3.enums.*;
// TODO Please do not forget delete unused imports
import org.openqa.selenium.By;
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
    // TODO Please do not forget delete commented lines
    //(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a")
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
    // TODO Please do not forget delete commented lines
    //xpath(".//img[@id='epam_logo']"
    private WebElement logo;

    @FindBy(css = "a[ui='link']")
    // TODO Please do not forget delete commented lines
    //xpath(".//a[text()='JDI Github']"
    private WebElement JDItitle;

    @FindBy(css = "div[name='navigation-sidebar']")
    // TODO Please do not forget delete commented lines
    //xpath(".//ul[@class='sidebar-menu']")
    private WebElement leftSection;

    @FindBy(css = "div[class='footer-bg']")
    // TODO Please do not forget delete commented lines
    //xpath(".//div[contains(@class, 'footer-content')]")
    private WebElement footer;


    //???
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // TODO missing empty line between methods
    //open url
    public void open(Links url){
        driver.get(url.getValue());
    }
    // TODO missing empty line between methods
    //checkTitle
    public void checkTitle(Titles title){
        assertEquals(driver.getTitle(), title.getValue());
    }
    // TODO missing empty line between methods
    //login
    public void login(Users user){
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }
    // TODO missing empty line between methods
    //check name
    public void checkUserName(Users user){
        assertEquals(userName.getText(), user.name);

    }
    // TODO missing empty line between methods
    //check TopBar
    // TODO What does topBar mean?
    public void checkTopBar(){
        assertEquals(topBar.size(), 4);
        // TODO please do not forget use {} brace for for cycle body
        for (int i = 0; i < 4; i++)
            assertTrue(topBar.get(i).isDisplayed());

        assertEquals(topBar.get(0).getText(), TopBars.topbarHOME.getValue());
        assertEquals(topBar.get(1).getText(), TopBars.topbarCONTACT.getValue());
        assertEquals(topBar.get(2).getText(), TopBars.topbarSERVICE.getValue());
        assertEquals(topBar.get(3).getText(), TopBars.topbarMETALS.getValue());
    }
    // TODO missing empty line between methods
    //check images
    // TODO What images do you check?
    public void checkImages(){
        assertEquals(image.size(), 4);
        // TODO please do not forget use {} brace for for cycle body
        for (int i = 0; i < 4; i++)
            assertTrue(image.get(i).isDisplayed());
    }
    // TODO missing empty line between methods
    //check texts
    // TODO What text do you check? Method name does not clear
    public void checkTexts() {
        Assert.assertEquals(text.size(), 4);
        // TODO please do not forget use {} brace for for cycle body
        for (int i = 0; i < 4; i++)
            assertTrue(text.get(i).isDisplayed());

        assertEquals(text.get(0).getText(), Texts.TextPRACTICE.getValue());
        assertEquals(text.get(1).getText(), Texts.TextCUSTOM.getValue());
        assertEquals(text.get(2).getText(), Texts.TextMULTI.getValue());
        assertEquals(text.get(3).getText(), Texts.TextBASE.getValue());
    }
    // TODO missing empty line between methods
    //check Header Text
    public void checkHeaderText(){
        assertEquals(headerText1.getText(), TextHeaders.TextHeader1.getValue());
        assertEquals(headerText2.getText(), TextHeaders.TextHeader2.getValue());
    }
    // TODO missing empty line between methods
    //check iFrame
    public void checkiFrame(){
        assertTrue(iframe.isDisplayed());
    }
    // TODO missing empty line between methods
    //check logo
    // TODO This method name does not correlated with body
    public void checkLogo() {
        driver.switchTo().frame(iframe);
        // TODO Where is assertion?
    }
    // TODO missing empty line between methods
    //swich to the other iFrame
    // TODO missing space between (){
    public void switchiFrame(){
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().window(windowHandler);
    }
    // TODO missing empty line between methods
    //Check JDI Title
    public void titleJDI(){
        assertEquals(JDItitle.getText(), Titles.JDITitle.getValue());
    }
    // TODO missing empty line between methods
    //check JDI link
    // TODO method name is not correlated with body
    public void linkJDI(){
        // TODO what is the purpose of the current assertion?
        assertEquals(JDItitle.getTagName(), Links.LinkTag.getValue());
        assertEquals(JDItitle.getAttribute("href"), Links.HPJDI.getValue());

    }
    // TODO missing empty line between methods
    // left section
    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }
    // TODO missing empty line between methods
    //footer
    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }

}
