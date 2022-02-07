package Tests;

import Builder.BasePage;
import Builder.DriverSingleton;
import Builder.Report;
import Builder.TakeScreenShot;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

public class ExtentReport extends BasePage {
    public static void extentReportTest() throws Exception {
        try {
            ((JavascriptExecutor) DriverSingleton.getDriverInstance()).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(DriverSingleton.getDriverInstance().getWindowHandles());
            DriverSingleton.getDriverInstance().close();
            DriverSingleton.getDriverInstance().switchTo().window(tabs.get(1));
            DriverSingleton.getDriverInstance().close();
            DriverSingleton.getDriverInstance().switchTo().window(tabs.get(2));
            DriverSingleton.getDriverInstance().navigate().to("https://translate.google.com/");
            TakeScreenShot.TakePicture();
            Report.test.log(Status.PASS , "Extent Report Pass :) ");
            DriverSingleton.getDriverInstance().navigate().to("https://dgotlieb.github.io/Navigation/Navigation.html");


        }catch (Exception e){
            Report.test.log(Status.FAIL , "Extent Report Test Fail :(");
            throw new Exception("Extent Report Test failed");
        }
    }

}
