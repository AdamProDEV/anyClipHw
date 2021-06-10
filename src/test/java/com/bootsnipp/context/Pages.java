package com.bootsnipp.context;

import com.bootsnipp.pages.*;
import org.openqa.selenium.WebDriver;

public class Pages {

    public HomePage homePage;
    public LoginPage loginPage;
    public UserProfilePage userProfilePage;

    public Pages (WebDriver webDriver){

        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        userProfilePage = new UserProfilePage(webDriver);

    }
}
