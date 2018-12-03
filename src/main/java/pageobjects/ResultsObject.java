package pageobjects;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultsObject {

    WebDriver driver;
    WebDriverWait wait;

    public ResultsObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1.srp-controls__count-heading")
    private WebElement lblResultsCount;

    @FindBy(css = "div.srp-controls--selected-value")
    private WebElement btnSorts;

    @FindBy(xpath = "//span[contains(text(), 'Precio + Envío: más bajo primero')]")
    private WebElement mnuSortByPriceAsc;

    @FindBy(css = "li.s-item")
    private List<WebElement> products;

    public String getResultsCount(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(lblResultsCount));
        return lblResultsCount.getText();
    }

    public void clickSortByPriceAsc(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnSorts));
        Actions action = new Actions(driver);
        action.moveToElement(btnSorts).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(mnuSortByPriceAsc));
        mnuSortByPriceAsc.click();
    }

    public Product getProduct(int index){
        Product prod = new Product();

        prod.setIndice(index);
        prod.setNombre(products.get(index).findElement(By.cssSelector("h3.s-item__title")).getText());
        prod.setPrice(Double.parseDouble(products.get(index).findElement(By.cssSelector("span.s-item__price")).getText().replace("S/. ", "")));

        return prod;
    }

    public boolean verifyPriceSortAsc(){
        boolean flag = false;

        List<String> list = new ArrayList<>();
        for(int i=0; i<5; i++){
            list.add(products.get(i).findElement(By.cssSelector("span.s-item__price")).getText());
        }

        flag = Ordering.natural().isOrdered(list);

        return flag;
    }
}