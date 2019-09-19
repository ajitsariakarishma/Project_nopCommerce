package NewProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static void isElementVisible(By by) {
        boolean status = driver.findElement(by).isDisplayed();
        System.out.println("Status of display of the Web Element: " + status);//if false then throws error

    }

    public static void isElementEnabled(By by) {
        boolean status = driver.findElement(by).isEnabled();
        System.out.println("Status of Web Element enabled: " + status);//is boolean function returns false if not enabled

    }

    public static void isElementSelected(By by) {
        boolean status = driver.findElement(by).isSelected();
        System.out.println("Status of Web Element selection: " + status);

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
        System.out.println("Attribute of the " +value+"  given is : "+atrribute);
        return atrribute;
    }

    public static String getCssPropertyOfWebElement(By by,String text){
        WebElement ele = driver.findElement(by);
        String cssProperty=ele.getCssValue(text);
        System.out.println("Css value of the  "+text+" is : "+cssProperty);
        return cssProperty;
    }

    public static void closeDriver(){
     driver.quit();
    }


}

