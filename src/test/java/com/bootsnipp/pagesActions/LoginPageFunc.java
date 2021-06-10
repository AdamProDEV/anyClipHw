package com.bootsnipp.pagesActions;

import com.bootsnipp.utils.TestUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class LoginPageFunc extends TestUtils {

    public void loginViaForm(String email, String password){

        seleniumUtils.sendTextToElement(pages.loginPage.fldEmail, email);
        seleniumUtils.sendTextToElement(pages.loginPage.fldPassword, password);
    }
}
