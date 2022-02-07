package Tests;

import Builder.BasePage;
import Builder.DriverSingleton;
import Builder.Report;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe extends BasePage {

    public static void iframeTest() throws Exception {
        try {
            DriverSingleton.getDriverInstance().switchTo().frame("my-frame");
            WebElement iframe = DriverSingleton.getDriverInstance().findElement(By.id("iframe_container"));
            String text = iframe.getText();
            System.out.println(text);

            DriverSingleton.getDriverInstance().switchTo().defaultContent();
            clickElement(By.id("openNewTab"));
            Report.test.log(Status.PASS , "Iframe Test Pass :)");




        }catch (Exception e){
            Report.test.log(Status.FAIL,  "Iframe Test Faild :(" );
            throw new Exception("IFrame Test failed");
        }



    }
}
