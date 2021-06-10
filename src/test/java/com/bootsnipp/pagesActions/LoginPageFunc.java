package com.bootsnipp.pagesActions;

import com.bootsnipp.utils.TestUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class LoginPageFunc extends TestUtils {

    public void loginViaForm(String email, String password, boolean checkBoxRemember) {

        seleniumUtils.verifyElementIsVisible(pages.loginPage.txtTitle);
        seleniumUtils.softAssert(pages.loginPage.txtTitle.getText().contains("sign in"),
                "Title have to be contains sign in words.");
        seleniumUtils.sendTextToElement(pages.loginPage.fldEmail, email);
        seleniumUtils.sendTextToElement(pages.loginPage.fldPassword, password);
        if (checkBoxRemember)
            seleniumUtils.clickOnElement(pages.loginPage.checkBoxRemember);
        seleniumUtils.clickOnElement(pages.loginPage.btnLogin);
    }
}
