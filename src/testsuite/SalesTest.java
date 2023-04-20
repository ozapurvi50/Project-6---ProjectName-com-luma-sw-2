package testsuite;

import browserfactory.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * * Verify total 12 Items displayed on page.
 */
public class SalesTest extends BaseTest {
    public static String baseUrl = "https://magento.softwaretestingboard.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage(){

        //Find element for dropdown arrow near account button
        WebElement womenDropdownButton = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        womenDropdownButton.click();

        //Find element for Create and account button
        WebElement signOutButton = driver.findElement(By.xpath("//a[contains(text(),'Jackets')]"));
        signOutButton.click();

        //List of images to check on webpage
        List<WebElement> sliderElementList = driver.findElements(By.xpath("//div[@data-container='product-grid']"));
        System.out.println("Total images are : " + sliderElementList.size());

        driver.close();
    }

}
