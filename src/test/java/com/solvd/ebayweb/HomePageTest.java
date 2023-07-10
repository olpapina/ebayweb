package com.solvd.ebayweb;

import com.solvd.ebayweb.component.DropDownMenu;
import com.solvd.ebayweb.exception.NotClickedException;
import com.solvd.ebayweb.page.HomePage;
import com.solvd.ebayweb.page.OtherVehiclesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class HomePageTest extends AbstractTest {

    @DataProvider(name = "titleText")
    public Object[][] dataTitle() {
        return new Object[][]{
                {"Electronics, Cars, Fashion, Collectibles & More | eBay"}
        };
    }

    @DataProvider(name = "vehiclesTitleText")
    public Object[][] dataVehiclesTitle() {
        return new Object[][]{
                {"Other Vehicles & Trailers for sale | eBay"}
        };
    }

    @Test(testName = "verify home page title text", dataProvider = "titleText")
    public void verifyTitleTest(String siteTitle) {
        HomePage homePage = new HomePage(getWebdriver());
        Assert.assertTrue(homePage.getTitle(siteTitle, 5), "The title is not expected");
    }

    @Test(testName = "verify that cookies will be accepted")
    public void verifyAcceptCookieTest() throws NotClickedException {
        HomePage homePage = new HomePage(getWebdriver());
        homePage.clickAccessAllButton();
        Assert.assertTrue(homePage.isClicked(), "Accept All button is not clicked");
    }

    @Test(testName = "verify redirect to Other Vehicles & Trailers page", dataProvider = "vehiclesTitleText")
    public void verifyRedirectToOtherVehiclesTest(String vehiclesTitle) throws NotClickedException {
        HomePage homePage = new HomePage(getWebdriver());
        homePage.clickAccessAllButton();
        DropDownMenu dropDownMenu = homePage.clickShopByCategory();
        OtherVehiclesPage otherVehiclesPage = dropDownMenu.clickOtherVehiclesPage();
        Assert.assertTrue(otherVehiclesPage.getTitle(vehiclesTitle, 5), "The title is not expected");
    }
}
