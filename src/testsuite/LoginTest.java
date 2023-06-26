package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp(){
        browserOpen(baseUrl);
    }
    @Test
    
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
        // Verify the text Welcome Back!
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test

        public void verifyTheErrorMessage() {
            // click on the ‘Sign In’ link
            driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
            // Enter invalid username
            driver.findElement(By.id("user[email]")).sendKeys("monday@gmail.com");
            // Enter invalid password
            driver.findElement(By.id("user[password]")).sendKeys("monday");
            // Click on Sign in button
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            // Verify the error message ‘Invalid email password.
            String expectedText = "Invalid email or password.";
            String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
            Assert.assertEquals(expectedText, actualText);
    }
}

