package com.bootsnipp.context;

import com.bootsnipp.pages.HomePage;
import com.bootsnipp.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Pages {

    public LoginPage loginPage;
    public HomePage homePage;
    public Pages (WebDriver webDriver){

        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);

    }
}
