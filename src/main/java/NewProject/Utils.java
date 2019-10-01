package NewProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.WEmbeddedFrame;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class Utils extends BasePage {
    //enter text at location
    public static void enterText(By by, String text) {

        driver.findElement(by).sendKeys(text);

    }

    // get text from  location
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    // click on web element
    public static void clickElement(By by) {
        driver.findElement(by).click();

    }

    // wait for element to be visiable
    public static void waitForElementVisible(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }

    //wait for element to clickable
    public static void waitUntilElementLoadsAndIsClickable(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //wait for alert to display
    public static void forAlterPresent(long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());

    }

    //to generate unique number everytime it runs
    public static String randomDate() {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("ddMMyyHHmmss");
        return simpledateformat.format(new Date());


    }

    //mouse hover movement
    public static void movedriverToWebElement(By by) {
        Actions actions = new Actions(driver);

        //storing location of dropdown in webelement variable
        WebElement menuList = driver.findElement(by);
        actions.moveToElement(menuList).perform();

    }

    //launching chrome driver with pre requisites
    public static void launchChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Resources\\WebBrowser\\chromedriver.exe");

        //open the browser
        driver = new ChromeDriver();

        //maximise the browser window screen
        driver.manage().window().fullscreen();

        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    //Handling dropdown by visible text
    public static void handlingDropdownByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);

    }

    //handling dropdown by value
    public static void handlingDropdownByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    //handling dropdown by index number
    public static void handlingDropdownByIndex(By by, int index_num) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index_num);
    }

    public static void conditionalWait(By by, int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        //wait.until(ExpectedConditions.)
    }

    public static void clearTextFromInputBoxArea(By by) {

        driver.findElement(by).clear();
    }

    public static void clearAndEnterText(By by, String text) {

        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);

    }

    public static boolean  isElementVisible(By by) {
        return driver.findElement(by).isDisplayed();

    }

    public static boolean isElementEnabled(By by) {
        return driver.findElement(by).isEnabled();

    }

    public static boolean isElementSelected(By by) {
        return driver.findElement(by).isSelected();


    }

    public static String gettingTextOfSelectedOptionFromDropdownByvisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
        WebElement option = select.getFirstSelectedOption();
        String selected_option = option.getText();
        System.out.println("Option seleted from dropdown is :  "+selected_option);
        return selected_option;

    }
    public static String gettingTextOfSelectedOptionFromDropdownByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
        WebElement option = select.getFirstSelectedOption();
        String selected_option = option.getText();
        System.out.println("Option seleted from dropdown is :  " + selected_option);
        return selected_option;
    }


    public static String gettingTextOfSelectedOptionFromDropdownByIndexNumber(By by, int index_num) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index_num);
        WebElement option = select.getFirstSelectedOption();
        String selected_option = option.getText();
        System.out.println("Option seleted from dropdown is :  " + selected_option);
        return selected_option;
    }

    public static String gettingAttributeofWebElement(By by, String value){
        WebElement ele = driver.findElement(by);
        String atrribute = ele.getAttribute(value);
        //System.out.println("Attribute of the " +value+"  given is : "+atrribute);
        return atrribute;
    }

    public static String getCssPropertyOfWebElement(By by,String text){
        WebElement ele = driver.findElement(by);
        String cssProperty=ele.getCssValue(text);
        //System.out.println("Css value of the  "+text+" is : "+cssProperty);
        return cssProperty;
    }

    //to verify and get the tittle of web page
    public static String verifytittle() {
        String tittle = driver.getTitle();
        System.out.println("Tittle of the active Webpage is:  " + tittle);
        return tittle;

    }

    //to navigate to any other url
    public static void toNavigatetoAnotherUrl(String url) {

        driver.navigate().to(url);
    }

    // to navigate backwards
    public static void toNavigateBackwards() {
        driver.navigate().back();
    }

    //to navigate forward
    public static void toNavigateForward() {
        driver.navigate().forward();

    }

    //to refreash webpage
    public static void toRefreashWebPage() {
        driver.navigate().refresh();
    }

    //handling bootstrap dropdown
    public static String bootStarpDropDown(By by, String text) {
        List<WebElement> list = driver.findElements(by);
        String actual = null;
        for (WebElement element : list) {
            actual = (element.getText());


            if (actual.equals(text)) {
                element.click();
                System.out.println("actual text is :" + actual);

                break;
            }

        }
        return actual;
    }

    public static void closeDriver(){
     driver.quit();
    }

     public static boolean isElementPresent(By by){
             try {
                 driver.findElement(by);
                 return true;
             } catch (org.openqa.selenium.NoSuchElementException e) {
                 return false;
             }
         }

         public static void scrollDown(By by){
             JavascriptExecutor js = (JavascriptExecutor) driver;
              js.executeScript("scroll(0,1000)");


         }

     }







