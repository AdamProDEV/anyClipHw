package com.bootsnipp.context;

import com.bootsnipp.flows.LoginToWebSiteFlow;
import com.bootsnipp.pagesActions.HomePageFunc;
import com.bootsnipp.pagesActions.LoginPageFunc;

public class SiteActions {

    public LoginPageFunc loginPageFunc = new LoginPageFunc();
    public HomePageFunc homePageFunc = new HomePageFunc();

    public LoginToWebSiteFlow loginToWebSiteFlow = new LoginToWebSiteFlow();
}
