package Listeners;

import Drivers.DriverFactory;
import Report.ExtentReportManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    private final Logger LOG = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("onTestStart: " + result.getMethod().getMethodName());
        ExtentReportManager.createTest(result.getMethod().getMethodName());
        String description = result.getMethod().getDescription();
        if (description != null)
            ExtentReportManager.info(description);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("onTestSuccess: " + result.getMethod().getMethodName() + " - PASSED");
        ExtentReportManager.pass("PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("onTestFailure: " + result.getMethod().getMethodName() + " - FAILED");
        LOG.error("Exception: " + result.getThrowable().toString());
        ExtentReportManager.fail("FAILED: " + result.getThrowable().toString());
        //Handle capture screenshot
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            LOG.error("Driver is null, cannot capture screenshot");
            return;
        }
        try {
            String path = ExtentReportManager.captureScreenshot(driver, result.getMethod().getMethodName());
            LOG.info("Saved screenshot: " + path);
        } catch (Exception e) {
            LOG.error("Capture screenshot failed: " + e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.info("onTestSkipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        LOG.info("onStart: " + context.getName());
        ExtentReportManager.initializeExtentReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        LOG.info("onFinish: " + context.getName());
        ExtentReportManager.flushReports();
    }
}
