package Builder;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {
    public static String takeScreenShot(String ImagesPath) throws Exception {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverSingleton.getDriverInstance();
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }



    public static  void TakePicture() throws Exception {
        String timeNow = String.valueOf(System.currentTimeMillis());
        Report.test.pass("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        takeScreenShot(timeNow);
    }

}
