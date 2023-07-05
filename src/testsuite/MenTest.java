package testsuite;

/**
 * Mouse Hover on Men Menu
 * Mouse Hover on Bottoms
 * Click on Pants
 * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on size 32.
 * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on colour Black.
 * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on colour Black.
 * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
 * Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
 * Click on ‘shopping cart’ Link into message
 * Verify the text ‘Shopping Cart.’
 * Verify the product name ‘Cronus Yoga Pant’
 * Verify the product size ‘32’
 * Verify the product colour ‘Black’
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {

        Thread.sleep(3000);

        // Mouse Hover on Men Menu
        mouseHoverToElement(By.id("ui-id-5"));
        Thread.sleep(3000);

        // Mouse Hover on Bottoms
        mouseHoverToElement(By.id("ui-id-18"));
        Thread.sleep(3000);
        // Click on Pants
        clickOnElement(By.id("ui-id-23"));
        Thread.sleep(3000);
        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on siz 32.
        clickOnElement(By.id("option-label-color-93-item-49"));
        clickOnElement(By.id("option-label-size-143-item-175"));

        Thread.sleep(3000);
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        clickOnElement(By.xpath("//li//button[@title='Add to Cart']"));

        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        List<WebElement> price = driver.findElements(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        for (WebElement e : price) {
            System.out.println(e.getText());
        }

        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        // Verify the text ‘Shopping Cart.’
        List<WebElement> shoppingCart = driver.findElements(By.xpath("//body/div[1]/main[1]/div[1]/h1[1]/span[1]"));
        for (WebElement e : shoppingCart) {
            System.out.println(e.getText());
        }

        // Verify the product name ‘Cronus Yoga Pant’
        List<WebElement> cronusYogaPant = driver.findElements(By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]"));
        for (WebElement e : cronusYogaPant) {
            System.out.println(e.getText());
        }

        // Verify the product size ‘32’
        List<WebElement> size32 = driver.findElements(By.xpath("//dd[contains(text(),'32')]"));
        for (WebElement e : size32) {
            System.out.println(e.getText());
        }

// Verify the product colour ‘Black’
        List<WebElement> black = driver.findElements(By.id("cart-238035-qty"));
        for (WebElement e : black) {
            System.out.println(e.getText());
        }}
    @After
        public void closeBrowser() {driver.quit();

    }}


