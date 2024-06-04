package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Requirement:
 * Create the package ‘browserfactory’ and create the class with the name ‘BaseTest’
 * inside the ‘browserfactory’ package. And write the browser setup code inside the class ‘Base
 * Test’.
 */
public class BaseTest {

    public String browser = "Chrome";

    public WebDriver driver;

    public void multiBrowser(String baseUrl) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        //get Url into browser
        driver.get(baseUrl);
        //Maximize browser window
        driver.manage().window().maximize();
        //implicit wait to browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void closeBrowser() {
        driver.quit();//close all the tabs using quit()
    }

}
