package com.bootsnipp.base.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class ExtentManager {

    private final ExtentReports extentReports;
    private ExtentSparkReporter reporter;

    public ExtentManager(){

        extentReports = new ExtentReports();
        reporter = new ExtentSparkReporter("report/report.html");
        reporter.config().setReportName("Home work");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author", "Adam");
    }

    public ExtentReports getExtentReports() {

        return extentReports;
    }
}
