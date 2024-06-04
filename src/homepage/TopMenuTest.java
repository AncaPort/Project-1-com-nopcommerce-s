package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * ● Create the package homepage
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */
public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        multiBrowser(baseUrl);
    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string

    public void selectMenu(String menu) {
        //1.2 This method should click on the menu whatever name is passed as parameter.
        List<WebElement> names = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/child::li"));
        for (WebElement name : names) {
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }

    /**
     * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
     * select the Menu and click on it and verify the page navigation.
     */
    @Test
    public void verifyPageNavigation() {
        List<String> names = new ArrayList<>();
        names.add("Computers");
        names.add("Electronics");
        names.add("Apparel");
        names.add("Digital downloads");
        names.add("Books");
        names.add("Jewelry");
        names.add("Gift Cards");

        for (int i = 0; i < names.size(); i++) {
            selectMenu(names.get(i));
            String actual = getTextFromElement(By.xpath("//h1[contains(text(),'" + names.get(i) + "')]"));
            Assert.assertEquals("", names.get(i), actual);
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
