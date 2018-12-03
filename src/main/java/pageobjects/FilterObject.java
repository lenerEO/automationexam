package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterObject {

    WebDriver driver;
    WebDriverWait wait;

    public FilterObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[aria-label='PUMA']")
    private WebElement chkBrandPuma;

    @FindBy(css = "input[aria-label='10']")
    private WebElement chkSizeTen;

    public void checkBrandPuma(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(chkBrandPuma));
        if(!chkBrandPuma.isSelected())
            chkBrandPuma.click();
    }

    public void uncheckPumaBrand(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(chkBrandPuma));
        if(chkBrandPuma.isSelected())
            chkBrandPuma.click();
    }

    public void checkSizeTen(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(chkSizeTen));
        if(!chkSizeTen.isSelected())
            chkSizeTen.click();
    }

    public void uncheckSizeTen(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(chkSizeTen));
        if(chkSizeTen.isSelected())
            chkSizeTen.click();
    }
}
