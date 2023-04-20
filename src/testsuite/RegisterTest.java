package testsuite;
/**
 *  Write down the following test into ‘RegisterTest’
 * class
 * 1. verifyThatSignInPageDisplay
 * * click on the ‘Create an Account’ link
 * * Verify the text ‘Create New Customer Account’
 * 2. userShouldRegisterAccountSuccessfully
 * * click on the ‘Create an Account’ link
 * * Enter First name
 * * Enter Last name
 * * Click on checkbox Sign Up for Newsletter
 * * Enter Email
 * * Enter Password
 * * Enter Confirm Password
 * * Click on Create an Account button
 * * Verify the text 'Thank you for
 * registering with Main Website Store.’
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out
 */

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    public static String baseUrl = "https://magento.softwaretestingboard.com/";


@Before
    public void setUp() {
        openBrowser(baseUrl);
    }

@Test
    public void verifyThatSignInPageDisplay() {

        //Find element for Create an Account and send click on button
        WebElement createAccount = driver.findElement(By.linkText("Create an Account"));
        createAccount.click();

    }
    @Test
    public void userShouldRegisterAccountSuccessfully() {

        //Find element for Create an Account and send click on button
        WebElement createAccount = driver.findElement(By.linkText("Create an Account"));
        createAccount.click();

        //Find element for FirstName and send text for FirstName field
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Pinks");

        //Find element for LastName and send text for LastName field
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Shah");

        //Find element for email and send text for email field
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("Prime1735@gmail.com");

        //Find element for password and send text for password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Pinks123*");

        //Find element for confirmation password and send text for confirmation password field
        WebElement conpassword = driver.findElement(By.name("password_confirmation"));
        conpassword.sendKeys("Pinks123*");

        //Find element for Create and account button
        WebElement createAccountButton = driver.findElement(By.xpath("//button[@class='action submit primary']/parent::div"));
        createAccountButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Comparing the web text with expected text
        String expectedMessage = "Thank you for registering with Main Website Store.";
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store.')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Text Not matched", expectedMessage, actualMessage);

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
