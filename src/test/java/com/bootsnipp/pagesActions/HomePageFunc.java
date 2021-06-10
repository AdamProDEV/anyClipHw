package com.bootsnipp.pagesActions;

import com.bootsnipp.utils.TestUtils;

public class HomePageFunc extends TestUtils {

    public void selectActionFromToolBarMenu(String menu){

        switch (menu){

            case "login":
                seleniumUtils.clickOnElement(pages.homePage.btnLogin);
        }
    }
}
