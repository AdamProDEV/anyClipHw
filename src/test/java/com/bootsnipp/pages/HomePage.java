package com.bootsnipp.pages;

import com.bootsnipp.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver){

        super(webDriver);
    }

    @FindBy(id = "nav-login-btn")
    public WebElement btnLogin;
}
