package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //Click on computer tab
        driver.findElement(By.xpath("(//a[contains(text(), 'Computers')])[1]")).click();
        String expectedText = "Computers";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        //Click on Elcetronics tab
        driver.findElement(By.xpath("(//a[contains(text(), 'Electronics')])[1]")).click();
        String expectedText = "Electronics";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        //Click on Apparel tab
        driver.findElement(By.xpath("(//a[contains(text(),'Apparel')])[1] ")).click();
        String expectedText = "Apparel";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        //Click on Downloads tab
        driver.findElement(By.xpath("(//a[contains(text(),'Digital downloads')])[1] ")).click();
        String expectedText = "Digital downloads";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        //Click on Books tab
        driver.findElement(By.xpath("(//a[contains(text(),'Books')])[1] ")).click();
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //Click on Jewelry tab
        driver.findElement(By.xpath("(//a[contains(text(),'Jewelry')])[1] ")).click();
        String expectedText = "Jewelry";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        //Click on Gift card tab
        driver.findElement(By.xpath("(//a[contains(text(),'Gift Cards ')])[1]")).click();
        String expectedText = "Gift Cards";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
