package listeners;

import base.BaseTest;
import com.aventstack.extentreports.*;
import org.testng.*;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent =
            ExtentManager.getReport();

    ExtentTest test;

    @Override
    public void onTestStart(
            ITestResult result) {

        test = extent.createTest(
                result.getName());
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        test.fail(result.getThrowable());

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        BaseTest.getPage(),
                        result.getName());

        test.addScreenCaptureFromPath(
                screenshotPath);
    }

    @Override
    public void onFinish(
            ITestContext context) {

        extent.flush();
    }
}