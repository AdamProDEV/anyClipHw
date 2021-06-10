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

    public WebElement verifyElementIsVisible(WebElement element){
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            printToLog(Status.PASS, element.toString() + " element is visible.");
        }catch (Exception e){
            printToLog(Status.WARNING, element.toString() + " element not visible. " + e);
        }
        return element;
    }

    public boolean isElementVisible(WebElement element){
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            printToLog(Status.PASS, element.toString() + " element is visible.");
            return true;
        }catch (Exception e){
            printToLog(Status.PASS, element.toString() + " element not visible." + e.getMessage());
            return false;
        }
    }

    public void clickOnElement(WebElement element){
        try {
            verifyElementIsVisible(element).click();
            printToLog(Status.PASS, element + " element successful clicked.");
        }catch (Exception e){
            hardAssert(false, element + " Failed click on element. " + e);
        }
    }

    public void sendTextToElement(WebElement element, String text){
        try {
            verifyElementIsVisible(element).sendKeys(text);
            printToLog(Status.PASS, element + " text: " + text + " , successful sent");
        }catch (Exception e){
            hardAssert(false, element + " Failed to send text: " + text + " . "  + e);
        }
    }

    public void hardAssert(boolean assertion, String description){

        if(!assertion){
            printToLog(Status.FAIL, description);
            Assertions.fail(description);
        }else {
            printToLog(Status.PASS, description );
        }
    }

    public void softAssert(boolean assertion, String description){
        if(!assertion)
            printToLog(Status.WARNING, description);
        else
            printToLog(Status.PASS, description );

    }

    public void printToLog(Status status, String message){
        ExtentReporter.logToReport(status, message);
        System.out.println(message);
    }
}
