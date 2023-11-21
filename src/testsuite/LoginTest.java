package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    static String baseurl = "https://demo.nopcommerce.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        // click on login link
        driver.findElement(By.linkText("Log in")).click();

        //Verify the welcome message
        String expectedWelcomeMsg = "Welcome, Please Sign In!";
        String actualWelcomeMsg = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedWelcomeMsg, actualWelcomeMsg);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        // click on login link
        driver.findElement(By.linkText("Log in")).click();
        Thread.sleep(5000);

       //Enter valid username
        driver.findElement(By.id("Email")).sendKeys("Kin123@gmail.com");
        Thread.sleep(5000);

        //Enter valid password
        driver.findElement(By.name("Password")).sendKeys("kin123!");
        Thread.sleep(5000);

        // Click on Login button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        Thread.sleep(5000);

        //Verify the logout message
        String expectedLogOutMsg = "Log out";
        String actualLogOutMsg = driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).getText();
        Assert.assertEquals(expectedLogOutMsg, actualLogOutMsg);
    }

    @Test
    public void verifyTheErrorMessage(){
        // click on login link
        driver.findElement(By.linkText("Log in")).click();

        //Enter invalid username
        driver.findElement(By.id("Email")).sendKeys("prime123@gmail.com");

        //Enter invalid password
        driver.findElement(By.name("Password")).sendKeys("pri123!");

        // Click on Login button
        driver.findElement(By.xpath("(//button[@type='submit' or class='button-1 search-box-button'])[2]")).click();

        // Verify the Error message
        String expectedErrorMsg = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualErrorMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
