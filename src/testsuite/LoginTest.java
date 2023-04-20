package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class LoginTest extends BaseTest {
    public static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1. userShouldLoginSuccessfullyWithValidCredentials

    @Test
    public void userShouldLoginSuccessfullyWithValidCredential() {
        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In ')]"));
        signIn.click();

        //Find element for email and send text for email field
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("Prime1734@gmail.com");

        //Find element for password and send text for password field
        WebElement password = driver.findElement(By.name("login[password]"));
        password.sendKeys("Pinks123*");

        //Find element for Create and account button
        WebElement signInButton = driver.findElement(By.xpath("//button[@name='send']"));
        signInButton.click();

        //Comparing the web text with expected text
        String expectedMessage2 = "Welcome, Pinks Shah!";
        WebElement actualMessageElement2 = driver.findElement(By.xpath("//span[contains(text(),'Welcome, Pinks Shah!')]"));
        String actualMessage2 = actualMessageElement2.getText();
        Assert.assertEquals("Text Not matched", expectedMessage2, actualMessage2);

        driver.close();
    }

    //2. verifyTheErrorMessageWithInvalidCredentials
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){
        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In ')]"));
        signIn.click();

        //Find element for email and send text for email field
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("Prime1734@gmail.com");

        //Find element for password and send text for password field
        WebElement password = driver.findElement(By.name("login[password]"));
        password.sendKeys("Pinks123*");

        //Find element for Create and account button
        WebElement signInButton = driver.findElement(By.xpath("//button[@name='send']"));
        signInButton.click();

        //Comparing the web text with expected text
        String expectedMessage3 = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement actualMessageElement3 = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]"));
        String actualMessage3 = actualMessageElement3.getText();
        Assert.assertEquals("Text Not matched", expectedMessage3, actualMessage3);

        driver.close();
    }

    //3. userShouldLogOutSuccessfully
@Test
    public void userShouldLogOutSuccessfully(){
        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In ')]"));
        signIn.click();

        //Find element for email and send text for email field
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("Prime1735@gmail.com");

        //Find element for password and send text for password field
        WebElement password = driver.findElement(By.name("login[password]"));
        password.sendKeys("Pinks123*");

        //Find element for Create and account button
        WebElement signInButton = driver.findElement(By.xpath("//button[@name='send']"));
        signInButton.click();

        //Comparing the web text with expected text
        String expectedMessage2 = "Welcome, Pinks Shah!";
        WebElement actualMessageElement2 = driver.findElement(By.xpath("//span[contains(text(),'Welcome, Pinks Shah!')]"));
        String actualMessage2 = actualMessageElement2.getText();
        Assert.assertEquals("Text Not matched", expectedMessage2, actualMessage2);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Find element for dropdown arrow near account button
        WebElement accountDropdownButton = driver.findElement(By.xpath("//button[@type='button']/parent::span"));
        accountDropdownButton.click();

        //Find element for Create and account button
        WebElement signOutButton = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        signOutButton.click();

        //Comparing the web text with expected text
        String expectedMessage1 = "You are signed out";
        WebElement actualMessageElement1 = driver.findElement(By.xpath("//span[contains(text(),'You are signed out')]"));
        String actualMessage1 = actualMessageElement1.getText();
        Assert.assertEquals("Text Not matched", expectedMessage1, actualMessage1);

        driver.close();
}
}
