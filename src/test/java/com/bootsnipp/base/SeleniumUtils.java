package com.bootsnipp.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.bootsnipp.base.extentReports.ExtentManager;
import com.bootsnipp.base.extentReports.ExtentReporter;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public SeleniumUtils(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(5000));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void openWebPage(String webPage){
        webDriver.get(webPage);
    }

    public void verifyElementIsVisible(WebElement element){
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            printToLog(Status.PASS, element.toString() + " element is visible.");
        }catch (Exception e){
            printToLog(Status.WARNING, element.toString() + " element not visible. " + e);
        }
    }

    public void clickOnElement(WebElement element){
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element)).click();
            printToLog(Status.PASS, element + " element successful clicked.");
        }catch (Exception e){
            hardAssert(false, element + " Failed click on element. " + e);
        }
    }

    public void hardAssert(boolean condition, String description){

        if(!condition){
            printToLog(Status.FAIL, description);
            Assertions.fail(description);
        }
    }

    public void printToLog(Status status, String message){
        ExtentReporter.logToReport(status, message);
        System.out.println(message);
    }
}
