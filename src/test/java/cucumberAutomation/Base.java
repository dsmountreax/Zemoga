package cucumberAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties prop;
    public WebDriverWait wait;

    public static WebDriver getDriver() throws IOException {

        String propPath="\\src\\test\\java\\cucumberAutomation\\global.properties";
        prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+propPath);
        prop.load(fis);

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(prop.getProperty("url"));
        fis.close();
        return driver;
    }


    //Wrapper function to get the title of the page
    public String getPageTitle() {return driver.getTitle();}

    //Wrapper function to get the header of the page
    public String getPageHeader(By locator) {return getElement(locator).getText();}

    //Wrapper function to get the element
    public WebElement getElement(By locator) {
        WebElement element;
        try{
            element=driver.findElement(locator);
            return element;
        }catch (Exception e)
        {
            System.out.println("Not able to find the element");
            e.printStackTrace();
        } return null;
    }

    //Wrapper function to wait for element to be present on the page
    public void waitForElementPresent(By locator){
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch(Exception e)
        {
            System.out.println("Some error occurred while waiting for the element" + locator.toString());
            e.printStackTrace();
        }
    }

    public List<WebElement> getElements(By locator)
    {
        List<WebElement> elements;
        try{
            elements= driver.findElements(locator);
            return elements;
        }catch(Exception e)
        {
            System.out.println("Some error occurred while waiting for the element"+ locator.toString());
            e.printStackTrace();
        }return null;
    }

    public WebElement getElementWithScope(WebElement scope, By locator)
    {
        WebElement element;
        try{
            element=scope.findElement(locator);
            return element;
        } catch (Exception e)
        {
            System.out.println("Not able to find element");
            e.printStackTrace();
        } return null;
    }
}
