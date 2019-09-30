package NewProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NopCommerceWithSoftAssertion extends Utils {
    LoadProperty props = new LoadProperty();

    @BeforeMethod
    public void setup() {
        launchChromeDriver();
        driver.get(props.getProperty("url"));

    }
    @Test
    public  void CountNumberofAddToCartButtonOnHomeoage() {
        int add_cart_true = 0;
        List<WebElement> list = (driver.findElements(By.xpath("//div[@class='item-box']")));
        for (WebElement ele : list) {
            if (ele.getAttribute("outerHTML").contains("Add to cart"))
            {
                add_cart_true++;
            }else{
                System.out.println("No Add To Cart button : "+ele.getText());

            }
        }
        Assert.assertEquals(add_cart_true,list.size(),"Above listed itmes donot have add to cart buttons: ");

    }
    @AfterMethod
    public void teardownr(){

        closeDriver();

    }





}
