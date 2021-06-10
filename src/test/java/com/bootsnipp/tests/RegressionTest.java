package com.bootsnipp.tests;

import com.bootsnipp.utils.TestUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegressionTest extends TestUtils {

    @Test
    @Order(1)
    @DisplayName("Login to website without 'remember me'")
    public void performLoginWithoutRememberOptionTest(){

        siteActions.loginToWebSiteFlow.performLoginWithoutRememberOption();
    }

    @Test
    @Order(2)
    @DisplayName("Login to website with 'remember me'")
    public void performLoginWithRememberOptionTest(){

        siteActions.loginToWebSiteFlow.performLoginWithRememberOption();
    }

    @Order(3)
    @ParameterizedTest
    @MethodSource("jsonData")
    void allUsersLoginTest(JsonNode user) {

        _step("Go to login page and perform login without remember checkbox");
        siteActions.homePageFunc.selectActionFromToolBarMenu("login");

        _step("Perform login without remember checkbox");
        siteActions.loginPageFunc.loginViaForm(user.path("email").asText(), user.path("password").asText(), false);

        _step("Profile page");
        seleniumUtils.hardAssert(!seleniumUtils.isElementVisible(pages.loginPage.txtIncorrectLogin), "Logon have to be successful");
        seleniumUtils.verifyElementIsVisible(pages.userProfilePage.txtTitle);
        seleniumUtils.softAssert(pages.userProfilePage.txtTitle.getText().trim().contains("My snippets"),
                "Title have to be: 'My snippets'");

    }

    private static Stream jsonData() throws Exception{

        return StreamSupport
                .stream((new ObjectMapper()).readTree(new File("src/test/resources/users/users.json"))
                        .path("users").spliterator(), false);
    }

}
