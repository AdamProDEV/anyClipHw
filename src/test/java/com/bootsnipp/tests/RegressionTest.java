package com.bootsnipp.tests;

import com.bootsnipp.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegressionTest extends TestUtils {

    @Test
    @DisplayName("Login to website 0")
    public void loginToWebTest0(){
        siteActions.loginToWebSiteFlow.performLogin();
    }

    @Test
    @DisplayName("Login to website 1")
    public void loginToWebTest1(){

        siteActions.loginToWebSiteFlow.performLogin();
    }

    @Test
    @DisplayName("Login to website 2")
    public void loginToWebTest2(){

        siteActions.loginToWebSiteFlow.performLogin();
    }
}
