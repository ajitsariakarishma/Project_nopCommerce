package NewProject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Shein_UK extends Utils {

    @Test

    public static void userShouldBeAbleToViewCurrentDateProductsInWhatsNewInWomenCategory(){

        launchChromeDriver();
        //open website Shein.co.uk
        driver.get("https://www.shein.co.uk/");
        movedriverToWebElement(By.xpath("//span[contains(text(),\"What's New\")]"));
        clickElement(By.xpath("//a[contains(text(),'09-24-2019')]"));
        String exp_date = gettingAttributeofWebElement(By.xpath("//a[@data-daily='2019-09-24']"),"data-daily");
        String temp = driver.getCurrentUrl();
       // System.out.println(temp);
        String arr[] = temp.split("=");
        String act_date = arr[4];
        Assert.assertEquals(act_date,exp_date);


    }


}
