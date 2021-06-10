package com.bootsnipp.pagesActions;

import com.bootsnipp.utils.TestUtils;

public class LoginPageFunc extends TestUtils {

    public void loginToWebSite(String email, String password){

        seleniumUtils.verifyElementIsVisible(pages.loginPage.fldEmail);
    }
}
