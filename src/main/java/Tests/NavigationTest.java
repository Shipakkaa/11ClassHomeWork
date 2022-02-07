package Tests;

import Builder.BasePage;
import Builder.DriverSingleton;
import Builder.Report;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NavigationTest extends BasePage {

    public static void navigationTest() throws Exception {
        try {
            clickElement(By.id("MyAlert"));
            Thread.sleep(2000);
           String alertText = DriverSingleton.getDriverInstance().switchTo().alert().getText();
            DriverSingleton.getDriverInstance().switchTo().alert().accept();
            System.out.println(alertText);
clickElement(By.id("MyPrompt"));
            Alert prompt = DriverSingleton.getDriverInstance().switchTo().alert();
            Thread.sleep(2000);
prompt.sendKeys("Omer"); //Not Working
            prompt.accept();
//            Assert.assertEquals(prompt , "Omer Brosh");  /// Not Working
            clickElement(By.id("MyConfirm"));
DriverSingleton.getDriverInstance().switchTo().alert().dismiss();
WebElement confirm = DriverSingleton.getDriverInstance().findElement(By.id("output"));
String confirmText = confirm.getText();
Assert.assertEquals(confirmText , "canceled");
            clickElement(By.id("openNewTab"));
String firstTab = DriverSingleton.getDriverInstance().getWindowHandle();
            DriverSingleton.getDriverInstance().switchTo().window(firstTab);
       WebElement g = DriverSingleton.getDriverInstance().findElement(By.cssSelector("#contact_info_left > a"));
       g.click();
            DriverSingleton.getDriverInstance().close();






            Report.test.log(Status.PASS, "Navigation Test Pass :)");
        } catch (Exception e) {
            Report.test.log(Status.FAIL, "Navigation Test Fail");
            throw new Exception("Navigation Test failed");
        }

    }
}
