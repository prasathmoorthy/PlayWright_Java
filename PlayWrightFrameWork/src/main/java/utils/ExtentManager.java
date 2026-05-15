package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(
                            "reports/extent-report.html");

            reporter.config().setReportName(
                    "Playwright Automation Report");

            reporter.config().setDocumentTitle(
                    "Test Results");

            extent = new ExtentReports();

            extent.attachReporter(reporter);
        }

        return extent;
    }
}