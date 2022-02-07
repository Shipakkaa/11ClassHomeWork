import Builder.DriverSingleton;
import Builder.Report;
import Tests.ExtentReport;
import Tests.Iframe;
import Tests.NavigationTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Run {
    @BeforeClass
    public static void beforeAll() throws Exception {
        DriverSingleton.getDriverInstance();
        DriverSingleton.getUrl();

    }

    @Test(priority = 1)
    public static void iframeTest() throws Exception {
        Iframe.iframeTest();

    }
    @Test(priority = 2)
    public static void testExtentReport () throws Exception {
        ExtentReport.extentReportTest();
    }
    @Test(priority = 3)
    public static void navigation() throws Exception {
        NavigationTest.navigationTest();
    }

@AfterClass
    public static void end(){
Report.extent.flush();
}
}