package testsuite;
/**
 * Mouse Hover on Gear Menu
 * Click on Bags
 * Click on Product Name ‘Overnight Duffle’
 * Verify the text ‘Overnight Duffle’
 * Change Qty 3
 * Click on ‘Add to Cart’ Button.
 * Verify the text ‘You added Overnight Duffle to your shopping cart.’
 * Click on ‘shopping cart’ Link into message
 * Verify the product name ‘Cronus Yoga Pant’
 * Verify the Qty is ‘3’
 * Verify the product price ‘$135.00’
 * Change Qty to ‘5’
 * Click on ‘Update Shopping Cart’ button
 * Verify the product price ‘$225.00’
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        //    Mouse Hover on Gear Menu
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Gear')]"));

        Thread.sleep(3000);
        //* Click on Bags
        clickOnElement(By.xpath("//span[contains(text(),'Bags')]"));
        Thread.sleep(3000);

        // Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        Thread.sleep(3000);

        // Verify the text ‘Overnight Duffle’
        List<WebElement> overnightDuffle = driver.findElements(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        for (WebElement e : overnightDuffle) {
            System.out.println(e.getText());

            // Change Qty 3
            driver.findElement(By.xpath("//input[@id='qty']")).clear();
            sendTextToElement(By.xpath("//input[@id='qty']"), "3");

            // Click on ‘Add to Cart’ Button.
            Thread.sleep(3000);
            clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));

            // Verify the text ‘You added Overnight Duffle to your shopping cart.’
            Thread.sleep(3000);
            List<WebElement> addedOvernightDuffle = driver.findElements(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
            for (WebElement a : addedOvernightDuffle) {
                System.out.println(a.getText());
            }

            // Click on ‘shopping cart’ Link into message
            Thread.sleep(3000);
            clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

            // Verify the product name ‘Cronus Yoga Pant’
            Thread.sleep(3000);
            List<WebElement> cronusYogaPant = driver.findElements(By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]"));
            for (WebElement b : cronusYogaPant) {
                System.out.println(b.getText());
            }

            // Verify the Qty is ‘3’
            Thread.sleep(3000);
            List<WebElement> qty3 = driver.findElements(By.xpath("//div[@class='control qty']"));
            for (WebElement c :qty3) {
                System.out.println(c.getText());
            }

            // Verify the product price ‘$135.00’
            String expectedPrice = "$135.00";
            String actualPrice = driver.findElement(By.xpath("//span[@class='cart-price']//span[contains(text(),'$135.00')]")).getText();
            Assert.assertEquals("Price do not match", expectedPrice, actualPrice);

            // Change Qty to ‘5’
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@value='3']")).clear();
            sendTextToElement(By.xpath("//input[@value='3']"), "5");

            // Click on ‘Update Shopping Cart’ button
            Thread.sleep(3000);
            clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

            // Verify the product price ‘$225.00’;
            Thread.sleep(3000);
            clickOnElement(By.xpath("//tbody/tr[1]/td[4]/span[1]/span[1]/span[1]"));
        }}
        @After
        public void tearDown() {
            closeBrowser();
    }
}
