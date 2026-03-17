package rbsOrg.TestComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportForReporting {
	static ExtentReports extent;  

	public static ExtentReports getReporterObject() {
		String filePath = "location for creating reports \\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
		reporter.config().setReportName("Appium Test Results");
		reporter.config().setDocumentTitle("Appium Test Results1");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "testerQA");
		return extent;

	}

}
