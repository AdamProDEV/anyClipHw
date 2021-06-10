package com.bootsnipp.flows;

import com.bootsnipp.utils.TestUtils;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;

public class LoginToWebSiteFlow extends TestUtils {

    public void performLogin(){
        siteActions.homePageFunc.selectActionFromToolBarMenu("login");
        JsonNode user = getJsonNode(new File("src/test/resources/users/users.json")).path("users").get(0);
        siteActions.loginPageFunc.loginViaForm(user.path("email").asText(), user.path("password").asText());

    }
}
