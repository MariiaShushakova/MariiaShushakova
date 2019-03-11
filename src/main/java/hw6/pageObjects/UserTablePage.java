package hw6.pageObjects;

import hw6.enums.TableNames;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;


public class UserTablePage {
    @FindBy(css = "#user-table tr > td > select")
    private ElementsCollection dropdowns;

    @FindBy(css = "#user-table tr > td > a")
    private ElementsCollection userNames;

    @FindBy(css = "#user-table tr > td > img")
    private ElementsCollection images;

    @FindBy(css = "#user-table tr > td > div > span")
    private ElementsCollection texts;

    @FindBy(css = "[type ='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "[class='panel-body-list logs'] > li")
    private ElementsCollection logs;

    @FindBy(css = "tr > td:first-child")
    private ElementsCollection numbers;


    public UserTablePage() {
        page(this);
    }

    public void checkDropdownsCount(int dropdownsCount) {
        dropdowns.shouldHaveSize(dropdownsCount);
    }

    public void checkNames(int namesCount) {
        userNames.shouldHaveSize(namesCount);
    }

    public void checkImages(int imagesCount) {
        images.shouldHaveSize(imagesCount);
    }

    public void checkTexts(int textsCount) {
        texts.shouldHaveSize(textsCount);
    }

    public void checkCheckboxes(int checkboxesCount) {
        checkboxes.shouldHaveSize(checkboxesCount);

    }

    public void checkUserTableValues(DataTable dataTable) {
        List<List<String>> table = dataTable.raw();
        for (int i = 0; i < table.size()-1 ; i++) {
            numbers.get(i).shouldHave(text(table.get(i + 1).get(0)));
            userNames.get(i).shouldHave(text(table.get(i + 1).get(1)));
            texts.get(i).shouldHave(text(table.get(i + 1).get(2)));
        }
    }

    public void selectVipCheckbox(TableNames userName) {
        for (SelenideElement vip : checkboxes) {
            if (userName.getValue().toLowerCase().contains(vip.getAttribute("id"))){
                    vip.click();
            }
        }
    }

    public void logRowHasTextInLogSection(int logIndex, String text) {
        logs.shouldHaveSize(logIndex);
        logs.shouldHave(texts(text));
    }

    public void clickDropdownForRoman() {
        dropdowns.first().click();
    }

    public void checkDropdownHasValues(List<String> values){
        ElementsCollection statuses = dropdowns.get(0).$$("option");
        for (int i = 0; i < values.size(); i++) {
            statuses.get(i).shouldHave(text(values.get(i)));
        }
    }
}