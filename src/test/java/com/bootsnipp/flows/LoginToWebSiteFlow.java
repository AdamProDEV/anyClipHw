package com.bootsnipp.flows;

import com.bootsnipp.utils.TestUtils;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;

public class LoginToWebSiteFlow extends TestUtils {

    public void performLoginWithoutRememberOption(){

        _step("Go to login page and perform login without remember checkbox");
        siteActions.homePageFunc.selectActionFromToolBarMenu("login");

        _step("Perform login without remember checkbox");
        JsonNode user = getJsonNode(new File("src/test/resources/users/users.json")).path("users").get(0);
        siteActions.loginPageFunc.loginViaForm(user.path("email").asText(), user.path("password").asText(), false);

        _step("Profile page");
        seleniumUtils.verifyElementIsVisible(pages.userProfilePage.txtTitle);
        seleniumUtils.softAssert(pages.userProfilePage.txtTitle.getText().trim().contains("My snippets"),
                "Title have to be: 'My snippets'");

//        _step("Verify remember me does not work.");
//        _step("Verify remember work.");
//        seleniumUtils.hardAssert(
//                seleniumUtils.getWebDriver().manage().getCookies().stream().noneMatch(cookie -> cookie.getName().contains("remember")),
//                "Cookies have not to be contains name 'remember'"
//        );
    }

    public void performLoginWithRememberOption(){

        _step("Go to login page and ");
        siteActions.homePageFunc.selectActionFromToolBarMenu("login");

        _step("Perform login with remember checkbox");
        JsonNode user = getJsonNode(new File("src/test/resources/users/users.json")).path("users").get(0);
        siteActions.loginPageFunc.loginViaForm(user.path("email").asText(), user.path("password").asText(), true);

        _step("Profile page");
        seleniumUtils.verifyElementIsVisible(pages.userProfilePage.txtTitle);
        seleniumUtils.softAssert(pages.userProfilePage.txtTitle.getText().trim().contains("My snippets"),
                "Title have to be: 'My snippets'");

        _step("Verify remember work.");
        seleniumUtils.hardAssert(
                seleniumUtils.getWebDriver().manage().getCookies().stream().anyMatch( cookie -> cookie.getName().contains("remember")),
                "Cookies have to be contains name 'remember' "
        );
    }
}
