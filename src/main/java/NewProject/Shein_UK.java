package NewProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Shein_UK extends Utils {


    @BeforeMethod
    public static void setup(){
        //ChromeOptions opt = new ChromeOptions();
        //ChromeOptions opt = opt.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Resources\\WebBrowser\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        //open the browser
        driver = new ChromeDriver();

        //maximise the browser window screen
        driver.manage().window().fullscreen();

        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //open website Shein.co.uk
        driver.get("https://www.shein.co.uk/");


    }

    @Test

    public static void userShouldBeAbleToViewCurrentDateProductsInWhatsNewInWomenCategory(){
movedriverToWebElement(By.xpath("//span[contains(text(),\"What's New\")]"));
        clickElement(By.xpath("//a[contains(text(),'09-24-2019')]"));
        String exp_date = gettingAttributeofWebElement(By.xpath("//a[@data-daily='2019-09-24']"),"data-daily");
        String temp = driver.getCurrentUrl();
       // System.out.println(temp);
        String arr[] = temp.split("=");
        String act_date = arr[4];
        Assert.assertEquals(act_date,exp_date);


    }

     @Test
    public static void userShouldBeAbleToAddTwoItemsFromKidsShoesAndAcceessoriesToShopingBasket() throws InterruptedException {
       clickElement(By.xpath("//a[@class='j-nav-first-cate j-nav-first-cate-3 first-cate ']"));
       movedriverToWebElement(By.xpath("//span[contains(text(),'Shoes & Accessories')]"));

       clickElement(By.xpath("//a[contains(text(),'Slippers')]"));
       Thread.sleep(5000);



       //clickElement(By.xpath("//button[@class=\"she-btn-white-opacity she-btn-s quick-add-btn j-btn-add-to-bag j-btn-add-to-bag-826650"));
       //clickElement(By.xpath("//span[contains(text(),'EUR28')]"));
       //clickElement(By.xpath("//button[contains(@class,'she-btn-black she-btn-s quick-add-btn-submit j-add-bag-submit j-add-bag-submit-826650')] "));

        //driver.switchTo().alert().dismiss();


     }

}
