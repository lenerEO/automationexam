package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.FilterObject;
import pageobjects.Product;
import pageobjects.ResultsObject;
import pageobjects.SearchObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Automation {

    WebDriver browser;

    @BeforeClass
    public void setUp(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\drivers\\chromedriver.exe");

        browser = new ChromeDriver();
        browser.get("https://www.ebay.com");

        browser.manage().window().maximize();
    }

    @Test
    public void Search() {
        SearchObject search = new SearchObject(browser);
        search.writeSearchTerm("shoes");
        search.clickSearch();

        FilterObject filter = new FilterObject(browser);
        filter.checkBrandPuma();
        filter.checkSizeTen();

        ResultsObject result = new ResultsObject(browser);
        System.out.println(result.getResultsCount());
        result.clickSortByPriceAsc();

        SoftAssert validate = new SoftAssert();
        validate.assertTrue(result.verifyPriceSortAsc());

        List<Product> prods = new ArrayList<>();

        for(int i=0; i<5; i++){
            prods.add(result.getProduct(i));
        }

        System.out.println("Cinco Primeros");

        for(Product p: prods) {
            System.out.println(p);
        }

        System.out.println("Cinco Primeros Ordenados por Nombre Ascendente");

        Collections.sort(prods, Product.PrdNameComparator);

        for(Product p: prods) {
            System.out.println(p);
        }

        System.out.println("Cinco Primeros Ordenados por Precio Descendente");

        Collections.sort(prods, Product.PrdPriceComparator);

        for(Product p: prods) {
            System.out.println(p);
        }
    }

    @AfterClass
    public void finish(){
        browser.quit();
    }
}