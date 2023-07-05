package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        // Mouse Hover on Women Menu
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        //Mouse Hover on Tops
        Thread.sleep(3000);
        mouseHoverToElement(By.linkText("Tops"));
        //Click on Jackets
        Thread.sleep(3000);
        clickOnElement(By.linkText("Jackets"));
        //Select Sort By filter “Product Name”
        Thread.sleep(3000);
        selectByValueFromDropDown(By.id("sorter"),"name");

        // Verify the products name display in alphabetical order
        List<WebElement> products = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
        for (WebElement e : products){
            System.out.println(e.getText());
        }}

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        Thread.sleep(3000);
        mouseHoverToElement(By.linkText("Tops"));
        Thread.sleep(3000);
        clickOnElement(By.linkText("Jackets"));
        Thread.sleep(3000);
        selectByValueFromDropDown(By.id("sorter"), "price");

        // Verify the products by price  by low to High
        List<WebElement> price = driver.findElements(By.xpath("//span[@data-price-type='finalPrice']"));
        for (WebElement e : price){
            System.out.println(e.getText());



        }}
    @After
    public void tearDown() {
       closeBrowser();
    }
}