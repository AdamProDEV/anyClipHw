package com.bootsnipp.pages;

import com.bootsnipp.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage {
    public UserProfilePage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/h1")
    public WebElement txtTitle;
}
