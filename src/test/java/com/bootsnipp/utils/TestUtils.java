package com.bootsnipp.utils;

import com.bootsnipp.base.TestBase;
import com.bootsnipp.context.Pages;
import com.bootsnipp.context.SiteActions;
import org.junit.jupiter.api.BeforeEach;

public class TestUtils extends TestBase {

    public static Pages pages;
    public static SiteActions siteActions;

    @BeforeEach
    public void init(){
        pages = new Pages(seleniumUtils.getWebDriver());
        siteActions = new SiteActions();
        seleniumUtils.openWebPage("https://bootsnipp.com");
    }

}
