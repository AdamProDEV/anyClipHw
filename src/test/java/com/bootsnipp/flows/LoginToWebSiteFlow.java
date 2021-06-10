package com.bootsnipp.flows;

import com.bootsnipp.utils.TestUtils;

public class LoginToWebSiteFlow extends TestUtils {

    public void performLogin(){
        siteActions.homePageFunc.selectActionFromToolBarMenu("login");
        siteActions.loginPageFunc.loginToWebSite("test@test.com", "123456");
    }
}
