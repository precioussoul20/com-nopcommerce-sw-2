package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //Click on register link
        driver.findElement(By.linkText("Register")).click();
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//a[contains(text(),'Register')]")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        driver.findElement(By.linkText("Register")).click();
        //select gender radio button
        driver.findElement(By.id("gender-female")).click();
        Thread.sleep(5000);

        //Enter first Name
        driver.findElement(By.id("FirstName")).sendKeys("Priya");
        Thread.sleep(5000);

        //Enter last Name
        driver.findElement(By.id("LastName")).sendKeys("Seth");
        Thread.sleep(5000);

        //Select Day, Month and Year
        driver.findElement(By.xpath("(//option[@value='1'])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//option[@value='7'])[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//option[@value='1984']")).click();
        Thread.sleep(5000);

        //Enter Email Address
        driver.findElement(By.id("Email")).sendKeys("priya123@gmail.com");
        Thread.sleep(5000);

        //Enter password
        driver.findElement(By.name("Password")).sendKeys("priya123!");
        Thread.sleep(5000);

        //Enter confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("priya123!");
        Thread.sleep(5000);

        // Click on register button
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(5000);

        //Verify the text
        String expectedText = "Your registration completed";
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
