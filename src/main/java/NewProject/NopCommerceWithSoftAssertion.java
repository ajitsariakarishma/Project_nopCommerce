package NewProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class NopCommerceWithSoftAssertion extends Utils {
    LoadProperty props = new LoadProperty();
    SoftAssert softassert = new SoftAssert();

    @BeforeMethod
    public void setup() {
        launchChromeDriver();
        driver.get(props.getProperty("url"));


    }
    @Test
    //Objective of the program was to check soft assertion and is purposefully written in a way to fail
    public  void CountNumberofAddToCartButtonOnHomeoage() {
        int add_cart_true = 0;// count variable to take count of items with add to cart button
        //creating list of elements for verifying Add To Cart button
        List<WebElement> list = (driver.findElements(By.xpath("//div[@class='item-box']")));
        for (WebElement ele : list) {

            if (ele.getAttribute("outerHTML").contains("Add to cart"))// checking element containg add to cart button from HTML dom
            {
                add_cart_true++;//above condition returns boolean hence if true the count will increase
            }else{
                System.out.println("No Add To Cart button : "+ele.getText());//if if statement returns false then else block shalll be executed

            }
        }
           softassert.assertEquals(add_cart_true,list.size());
           System.out.println("Above "+(list.size()-add_cart_true)+"  items donot have 'Add To Cart' button: ");
           softassert.assertAll();

    }

    @Test
    public void userIsABleToAdd_View_Remove_2items_UsingCompareToTab() throws InterruptedException {
        int item_count=0;
        int no_item=0;
        //Asserting the title of the page
        String exp_title = "nopCommerce demo store";
        //System.out.println( driver.getTitle());
        softassert.assertEquals(driver.getTitle(), exp_title, "Tittle doesnot match");

        //clicking on compare to button
        clickElement(By.xpath("//div[@class='page-body']//div[1]//div[1]//div[2]//div[3]//div[2]//input[2]"));
        waitForElementVisible(By.xpath("//div[@class='bar-notification success']"),2000);//waiting for confirmation message to be displayed
        String actual = getTextFromElement(By.xpath("//div[@class='bar-notification success']"));//getting text from confirmation bar
        String expected="The product has been added to your product comparison";
        //Asserting whether the 1st product is added or not
        softassert.assertEquals(actual,expected,"first product is not added to compare list successfully");

        //clicking on compare to button
        clickElement(By.xpath("//div[@class='item-grid']//div[2]//div[1]//div[2]//div[3]//div[2]//input[2]"));
        waitForElementVisible(By.xpath("//div[@class='bar-notification success']"),3000);//waiting for confirmation message bar to be displayed
        Thread.sleep(2000);// had to use as needed more time
        String actual_2 = getTextFromElement(By.xpath("//div[@class='bar-notification success']"));//getting text from confirmation message bar
        String expected2="The product has been added to your product comparison";
        //Asserting whether the 2nd product is added or not
        softassert.assertEquals(actual_2, expected2,"second product is not added to compare list successfully");

        waitForElementVisible(By.linkText("Compare products list"), 2000);//waiting for compare to table to be updated
        toNavigatetoAnotherUrl("https://demo.nopcommerce.com/compareproducts");//navigating to compare to page to view table

        //System.out.println(getTextFromElement(By.xpath("//tr[@class='product-name']")));

        //getting text from tittle row of the table, returns tittle of product in one line, storing the same in a String variable
        String actual_products=getTextFromElement(By.xpath("//tr[@class='product-name']"));
        if(actual_products.contains("Apple")){//checking the presence of product in list by key word
            item_count++;//increasing the item count after confirming  presence of the product
        }else{
            no_item++;//getting the count in case item is not present
        }
        if(actual_products.contains("Build")){//checking the presence of product in list by key word
            item_count++;//increasing the item count after confirming presence of the product

        }else{
            no_item++;// getting the count in case item is not present
        }
        softassert.assertEquals(item_count,2,no_item+" are not present for comparision");

        clickElement(By.xpath("//a[@class='clear-list']"));//click on clear list button
        String actual_clear_msg=getTextFromElement(By.xpath("//div[@class='no-data']"));
        String expected_clear_msg="You have no items to compare.";
        softassert.assertEquals(actual_clear_msg,expected_clear_msg,"List is not empty after clicking on clear tab button");

       softassert.assertAll();
    }

    @Test
    public void userShouldBeAbleToAddCommentsAndTheSameShouldBeDisplayedAttheBottomOfTheList() {

        boolean test = false;
        ((JavascriptExecutor) driver).executeScript("scroll(0,1500)");//scrolling at the bottom of the page
        clickElement(By.xpath("//a[contains(text(),'nopCommerce new release!')]"));//click on new button
        enterText(By.xpath("//input[@id='AddNewComment_CommentTitle']"), props.getProperty("news_comment_tittle"));//adding tittle

        //entering comment
        enterText(By.xpath(" //textarea[@id='AddNewComment_CommentText']"),props.getProperty("comment_text"));//writing comment
        clickElement(By.xpath("//input[@name='add-comment']"));//clicking on add comment button

        String expected_add_comment_msg="News comment is successfully added.";
        String actual_add_comment_msg= getTextFromElement(By.xpath("//div[@class='result']"));

        softassert.assertEquals(actual_add_comment_msg,expected_add_comment_msg,"Comment is not added");

        //making a list of all the tittles in comment list
        List<WebElement> commentList = driver.findElements(By.xpath("//div[@class='comments']//div[2]//div[@class='comment-title']"));



        WebElement last_element = commentList.get(commentList.size()-1);//storing last value of list in a web element reference
        String last_ele_text=(last_element.getText());// getting text of last element
        if(last_ele_text.contains(props.getProperty("news_comment_tittle"))){//verifying title
          test = true;//setting condition for assertion
        }
        //aseerting the comment is added at the bnottom of the list or not
         softassert.assertTrue(test," Commment is not added at the bottom of the list.");

        softassert.assertAll();


    }
    @Test
    public void validatingSearchFunctionality(){
        int count=0;
        int count1=0;
        enterText(By.xpath("//input[@id='small-searchterms']"),props.getProperty("productname"));//entgering text for search
        clickElement(By.xpath("//input[@class='button-1 search-box-button']"));//clicking on search tab
        List<WebElement>titleList=driver.findElements(By.xpath("//div[@class='item-grid']//h2"));
        System.out.println(titleList.size());
        if(titleList.size()==0){
            System.out.println("no items found");

        }
        for(WebElement element:titleList){
            if(element.getText().contains(props.getProperty("productname"))){//verifying relevence of product according search
               String product =(element.getText());//storing text of product in string
                System.out.println(("products shown on page are: "+product));//listing the products titles on console
                count++;//increasing count to validate with list size
            }else{
                count1++;//getting the count of products listed that donot match search criteria
               //printing the products on console which are not in releavance according to search
                System.out.println(count1+ " these item donot have " +props.getProperty("productname")+" : " +element.getText());
            }
        }
        System.out.println(count);
        // validation of search functionality
        softassert.assertEquals(titleList.size(),count,"Above listed items donot match search criteria");

        softassert.assertAll();
    }
       @AfterMethod
       public void teardownr(){

        closeDriver();

    }

}
