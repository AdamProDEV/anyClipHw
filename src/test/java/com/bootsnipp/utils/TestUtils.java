package com.bootsnipp.utils;

import com.aventstack.extentreports.Status;
import com.bootsnipp.base.TestBase;
import com.bootsnipp.context.Pages;
import com.bootsnipp.context.SiteActions;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

public class TestUtils extends TestBase {

    public static Pages pages;
    public static SiteActions siteActions;

    @BeforeEach
    public void init(){
        pages = new Pages(seleniumUtils.getWebDriver());
        siteActions = new SiteActions();
        seleniumUtils.openWebPage("https://bootsnipp.com");
    }

    public JsonNode getJsonNode(File jsonPath){
        try{
            return (new ObjectMapper()).readTree(jsonPath);
        }catch (Exception e){
            seleniumUtils.printToLog(Status.INFO, "Failed parse Json, " + e);
            return  null;
        }
    }

}
