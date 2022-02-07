package Builder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Report {


    public static ExtentReports extent;

    public static ExtentTest test;

    public static void beforeClass() throws Exception {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\Report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Selenium", "My HomeWork ");
        test.log(Status.INFO, "@Before class");
        extent.setSystemInfo("Selenium Version", "1.0");
        extent.setSystemInfo("Live", "Maccabi");
    }
}