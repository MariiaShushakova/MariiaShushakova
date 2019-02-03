package HW3;

import HW3.enums.*;
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
    //xpath(".//img[@id='epam_logo']"
    private WebElement logo;

    @FindBy(css = "a[ui='link']")
    //xpath(".//a[text()='JDI Github']"
    private WebElement JDItitle;

    @FindBy(css = "div[name='navigation-sidebar']")
    //xpath(".//ul[@class='sidebar-menu']")
    private WebElement leftSection;

    @FindBy(css = "div[class='footer-bg']")
    //xpath(".//div[contains(@class, 'footer-content')]")
    private WebElement footer;


    //???
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //open url
    public void open(Links url){
        driver.get(url.getValue());
    }
    //checkTitle
    public void checkTitle(Titles title){
        assertEquals(driver.getTitle(), title.getValue());
    }
    //login
    public void login(Users user){
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }
    //check name
    public void checkUserName(Users user){
        assertEquals(userName.getText(), user.name);

    }
    //check TopBar
    public void checkTopBar(){
        assertEquals(topBar.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(topBar.get(i).isDisplayed());

        assertEquals(topBar.get(0).getText(), TopBars.topbarHOME.getValue());
        assertEquals(topBar.get(1).getText(), TopBars.topbarCONTACT.getValue());
        assertEquals(topBar.get(2).getText(), TopBars.topbarSERVICE.getValue());
        assertEquals(topBar.get(3).getText(), TopBars.topbarMETALS.getValue());
    }
    //check images
    public void checkImages(){
        assertEquals(image.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(image.get(i).isDisplayed());
    }
    //check texts
    public void checkTexts() {
        Assert.assertEquals(text.size(), 4);
        for (int i = 0; i < 4; i++)
            assertTrue(text.get(i).isDisplayed());

        assertEquals(text.get(0).getText(), Texts.TextPRACTICE.getValue());
        assertEquals(text.get(1).getText(), Texts.TextCUSTOM.getValue());
        assertEquals(text.get(2).getText(), Texts.TextMULTI.getValue());
        assertEquals(text.get(3).getText(), Texts.TextBASE.getValue());
    }
    //check Header Text
    public void checkHeaderText(){
        assertEquals(headerText1.getText(), TextHeaders.TextHeader1.getValue());
        assertEquals(headerText2.getText(), TextHeaders.TextHeader2.getValue());
    }
    //check iFrame
    public void checkiFrame(){
        assertTrue(iframe.isDisplayed());
    }
    //check logo
    public void checkLogo() {
        driver.switchTo().frame(iframe);
    }
    //swich to the other iFrame
    public void switchiFrame(){
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().window(windowHandler);
    }
    //Check JDI Title
    public void titleJDI(){
        assertEquals(JDItitle.getText(), Titles.JDITitle.getValue());
    }
    //check JDI link
    public void linkJDI(){
        assertEquals(JDItitle.getTagName(), Links.LinkTag.getValue());
        assertEquals(JDItitle.getAttribute("href"), Links.HPJDI.getValue());

    }
    // left section
    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }
    //footer
    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }

}
