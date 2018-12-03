package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchObject {
    WebDriver driver;
    WebDriverWait wait;

    public SearchObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gh-ac")
    private WebElement txtSearch;

    @FindBy(id = "gh-btn")
    private WebElement btnSearch;

    public void writeSearchTerm(String term){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(txtSearch));
        txtSearch.sendKeys(term);
    }

    public void clickSearch(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnSearch));
        btnSearch.click();
    }
}
