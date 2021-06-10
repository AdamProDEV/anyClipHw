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

}
