package NewProject;

import javafx.scene.input.DataFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static okhttp3.internal.http.HttpDate.format;
import static org.openqa.selenium.By.xpath;

public class NopCommerce extends Utils {

    LoadProperty props = new LoadProperty();


    @BeforeMethod
    public void setup() {
        launchChromeDriver();
        driver.get(props.getProperty("url"));

    }

    @Test
    public void userShouldBeAbleToRegisterSuccesfully() {

        //click on 'Register' button
        clickElement(By.xpath("//a[@class='ico-register']"));

        //enter firstname
        enterText(By.id("FirstName"), props.getProperty("Firstname"));

        //enter last name
        enterText(By.xpath("//input[@name='LastName']"), props.getProperty("Lastname"));

        //Eneterting DOB
        handlingDropdownByVisibleText(By.xpath("//select[@name='DateOfBirthDay']"), "5");
        handlingDropdownByValue(By.xpath("//select[@name='DateOfBirthMonth']"), "10");
        handlingDropdownByIndex(By.xpath("//select[@name='DateOfBirthYear']"), 80);

        //enter email
        enterText(By.name("Email"), props.getProperty("email_start") + randomDate() + props.getProperty("email_end"));


        //enter password
        enterText(By.id("Password"), props.getProperty("password"));

        //enter confirm password
        enterText(By.xpath("//input[@name=\'ConfirmPassword']"), props.getProperty("password"));

        //click on register button
        clickElement(By.xpath("//input[@type='submit' and @name='register-button']"));

        //storing value of actual in a string variable
        String actual_msg = getTextFromElement(By.className("result"));
        String expected_msg = "Your registration completed";
        System.out.println("Actual Message is : " + actual_msg);

        //comparing actual message with expected message
        Assert.assertEquals(actual_msg, expected_msg);

    }

    @Test
    public void emailFriend() {

        userShouldBeAbleToRegisterSuccesfully();

        //click on nop commerce icon for opening homepage
        clickElement(By.xpath("//img[@alt='nopCommerce demo store']"));

        //click on imac pro image
        clickElement(By.xpath("//img[@title='Show details for Apple MacBook Pro 13-inch']"));

        //click on email friend
        clickElement(By.xpath("//input[@value='Email a friend']"));

        //enter email id of friend
        enterText(By.xpath("//input[@class='friend-email']"), props.getProperty("friend_email"));


        //enter message
        enterText(By.id("PersonalMessage"), props.getProperty("email_msg"));

        //click on send email button
        clickElement(By.xpath("//input[@value='Send email']"));

        String expectedConfirmMessage = "Your message has been sent.";
        String actualmessage = getTextFromElement(By.xpath("//div[@class='result']"));
        System.out.println("Acutal confirmation message is : " + actualmessage);
        Assert.assertEquals(actualmessage, expectedConfirmMessage);//comparing actual result with expected.

    }

    @Test
    public void userShouldBeAbleToNavigateToCameraandPhotoPage() {
        //creating instance of action class for mouse hover.
        movedriverToWebElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));

        //selecting and clicking camera and photo subcategory.
        clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));


        //getting and storing actual display message.
        String actual_msg = getTextFromElement(By.xpath("//h1"));

        String expected_msg = "Camera & photo";
        System.out.println("Actual tittle displayed is: " + actual_msg);

        //asserting the validity.
        Assert.assertEquals(actual_msg, expected_msg);
    }

    @Test
    public void userShouldBeAbleToFilterJewelleryByPrice() {
        String ans;

        //Clicking on Jewellery link on the homepage.
        clickElement(By.xpath(" //ul[@class='top-menu notmobile']//a[contains(text(),'Jewelry')]"));

        //Clicking on the filter attribute of range $700-$3000
        clickElement(By.cssSelector("a[href='//demo.nopcommerce.com/jewelry?price=700-3000']"));

        //getting relevant text according to the filter selected.
        String price = getTextFromElement(By.xpath("//span[@class='price actual-price']"));
        System.out.println(price);


        //eliminating junk characters and converting string to integer value.
        price = price.substring(0, 6);
        price = price.replaceAll("[^0-9]", "");
        int x = Integer.parseInt(price);
        //checking the filter function
        if (x >= 700 && x <= 3000) {
            ans = "PASSED";
            System.out.println("Your test has " + ans);
        } else {

            ans = "FAILED";
            System.out.println("Your test has " + ans);

        }
        //checking user is navigated to jewllery page
        String pageTitle = getTextFromElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        String actual_title = "Jewelry";
        System.out.println("you are navigated to :" + actual_title + " page.");
        Assert.assertEquals(pageTitle, actual_title);
    }

    @Test
    public void userShouldBeAbleToAddTheProductsToTheShoppingCart() {

        //clicking on books link
        clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));

        //Clicking on a book
        clickElement(By.xpath("//img[@alt='Picture of Fahrenheit 451 by Ray Bradbury']"));

        //adding a book to the cart
        clickElement(By.cssSelector("#add-to-cart-button-37"));

        //clicking on books link
        clickElement(By.xpath("//span[contains(text(),'Books')]"));

        //selecting another book to add to cart
        clickElement(By.cssSelector("img[title$='Prejudice']"));

        //adding to cart
        clickElement(By.cssSelector("#add-to-cart-button-39"));

        //instructing browser to wait
        waitUntilElementLoadsAndIsClickable(By.cssSelector("img[title$='Prejudice']"), 60);

        //clicking on shopping cart label to view the products added
        clickElement(By.xpath("//span[@class='cart-label']"));

        movedriverToWebElement(By.xpath("//span[@class='cart-label']"));


        //storing and getting string value in a variable
        String qty = getTextFromElement(By.xpath("//span[@class='cart-qty']"));
        System.out.println("actual qty ordered: " + qty);
        String expected_qty = "(2)";
        Assert.assertEquals(qty, expected_qty);

    }
       @AfterMethod
        public void teardownr(){

            closeDriver();

        }

}



