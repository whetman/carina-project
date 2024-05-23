package com.solvd.web;

import com.solvd.gui.pages.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class HomePageTests implements IAbstractTest {


    @Test
    public void openHomePage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue("Home page is not opened", homePage.isPageOpened());
    }

}
