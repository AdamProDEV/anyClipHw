package com.bootsnipp.pages;

import com.bootsnipp.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "email")
    public WebElement fldEmail;

    @FindBy(name = "password")
    public WebElement fldPassword;


}
