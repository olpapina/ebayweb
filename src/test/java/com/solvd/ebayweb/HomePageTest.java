package com.solvd.ebayweb;

import com.solvd.ebayweb.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class HomePageTest extends AbstractTest {

    @DataProvider(name = "rightTitleText")
    public Object[][] dataTitle() {
        return new Object[][]{
                {"Electronics, Cars, Fashion, Collectibles & More | eBay"}
        };
    }

    @DataProvider(name = "falseTitleText")
    public Object[][] dataFalseTitle() {
        return new Object[][]{
                {"There is text for false result test"}
        };
    }

    @Test(testName = "verify that title text is right", dataProvider = "rightTitleText")
    public void verifyTitleTest(String siteTitle) {
        HomePage homePage = new HomePage(getWebdriver());
        Assert.assertTrue(homePage.getTitle(siteTitle, 5), "The title is not expected");
    }

    @Test(testName = "verify that title text is wrong", dataProvider = "falseTitleText")
    public void verifyWrongTitleTest(String siteTitle) {
        HomePage homePage = new HomePage(getWebdriver());
        Assert.assertFalse(homePage.getTitle(siteTitle, 5), "The title is not expected");
    }
}
