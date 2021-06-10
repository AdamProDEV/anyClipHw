package com.bootsnipp.pages;

import com.bootsnipp.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id=\"loginform\"]/fieldset/h3")
    public WebElement txtTitle;

    @FindBy(name = "email")
    public WebElement fldEmail;


    @FindBy(name = "password")
    public WebElement fldPassword;

    @FindBy(name = "remember")
    public WebElement checkBoxRemember;

    @FindBy(xpath = "//*[@value=\"Login\"]")
    public WebElement btnLogin;

    @FindBy(xpath = "//*[@class=\"alert bs-callout bs-callout-danger alert-dismissible\"]")
    public WebElement txtIncorrectLogin;



}
