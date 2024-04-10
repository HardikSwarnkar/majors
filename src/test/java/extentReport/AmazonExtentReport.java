package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AmazonExtentReport {

	
	private static ExtentSparkReporter htmlReporter;
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance() {
		 if (extent == null) {
	            extent = new ExtentReports();
	            // Define the directory path where you want to save the report
	            String reportDirectory = "extentReport/";
	            htmlReporter = new ExtentSparkReporter(reportDirectory + "extentReport.html");
	            // Configure report settings
	            htmlReporter.config().setReportName("Test Report");
	            htmlReporter.config().setDocumentTitle("Extent Report");
	            htmlReporter.config().setTheme(Theme.STANDARD);
	            extent.attachReporter(htmlReporter);
	        }

		return extent;
	}
	
	public static void flushReport() {
		if(extent!=null) {
			extent.flush();
		}
	}
	
}
