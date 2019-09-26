import NewProject.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class spicejet extends Utils {

    @Test
     public static void trial(){
        String expected_dep = "Aurangabad (IXU)";
        String expected_arr = "Delhi (DEL)";
        String date = "30";


        launchChromeDriver();
        driver.get("https://www.spicejet.com");
        clickElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
        bootStarpDropDown(By.xpath("//*[@id='citydropdown']//tbody//ul//li"),expected_dep);
        clickElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
        bootStarpDropDown(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a"),expected_arr);
        bootStarpDropDown(By.xpath("//*[@id='ui-datepicker-div']//table//tbody//td"),date);









    }




}
