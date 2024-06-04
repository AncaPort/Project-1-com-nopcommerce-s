package utilities;
/**
 * Create the package utilities and create the class with the name ‘Utility’ inside the ‘utilities’
 * package. And write the all the utility methods in it’.
 */

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    //************************* Alert Methods *****************************************************

    //1.switchToAlert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //2.acceptAlert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //3.dismissAlert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //4.sentTextToAlert
    public void sentTextToAlert(By by, String text) {
        driver.switchTo().alert().sendKeys(text);
        // driver.findElement(by).sendTextToAlert(by,text);
    }

    //5.getTextFromAlert
    public String getTextFromAlert(By by) {
        return driver.switchTo().alert().getText();
        //  return driver.findElement(by).getText()
    }


    //*************************** Select Class Methods ***************************************//
    //1.selectByValueFromDropDown(By by,string value)
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select class
        Select select = new Select(dropDown);
        // Select by visible Text
        select.selectByValue(value);
    }

    //2. selectByIndexFromDropDown(By by ,int index)
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement index1 = driver.findElement(by);
        Select select = new Select(index1);
        select.selectByIndex(index);
    }

    //3. selectByVisibleTextFromDropDown(By by,string text)
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement visibleText = driver.findElement(by);
        Select select = new Select(visibleText);
        select.selectByVisibleText(text);
    }
    // This method will select the option by value
    public void selectOptionByValue(By by, String value) {
        WebElement optionByValue = driver.findElement(by);
        Select select = new Select(optionByValue);
        select.selectByValue(value);

    }

    //  This method will select the option by index
    public void selectOptionByIndex(By by, int index) {
        WebElement optionByIndex = driver.findElement(by);
        Select select = new Select(optionByIndex);
        select.selectByIndex(index);

    }

    // This method will select the option by contains text
    public void selectOptionByContainsText(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
    }

//********************* Verify expected Vs Actual Method***************

    public void verifyExpectedAndActual(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        Assert.assertEquals(expectedText, actualText);
    }

    public void verifyMessage(String expectedMessage, String actualMessage) {
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    //***************************Action Methods************************
    // 1. mouseHoverToElement
    public void mouseHoverToElement(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();

    }
    public void mouseHoverAndClickToElement(By by) {
        WebElement mouseHoverAndClick = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHoverAndClick).click().build().perform();
    }

    //**************************** multiple********************************
    //multiple elements store in list of webelement
    public List<WebElement> getMultipleElements(By by) {
        return driver.findElements(by);
    }
}
