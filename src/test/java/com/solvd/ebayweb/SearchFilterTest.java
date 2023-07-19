package com.solvd.ebayweb;

import com.solvd.ebayweb.component.DropDownMenu;
import com.solvd.ebayweb.component.SearchBlock;
import com.solvd.ebayweb.page.CommercialMixerPage;
import com.solvd.ebayweb.page.HomePage;
import com.solvd.ebayweb.page.RestaurantFoodServicePage;
import com.solvd.ebayweb.page.ResultPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;

public class SearchFilterTest extends AbstractTest {

    @DataProvider(name = "mixersTitleText")
    public Object[][] dataMixersTitle() {
        return new Object[][]{
                {"Mixer in Restaurant & Food Service for sale | eBay", "Mixer"}
        };
    }

    @DataProvider(name = "productsData")
    public Object[][] dataProducts() {
        return new Object[][]{
                {"iphone for sale | eBay", "iphone", new BigDecimal(140.00)}
        };
    }

    @DataProvider(name = "comMixerData")
    public Object[][] dataComMixers() {
        return new Object[][]{
                {"Globe Commercial Mixers for sale | eBay", "globe"}
        };
    }

    @Test(testName = "verify Mixers is selected in the results", dataProvider = "mixersTitleText")
    public void verifySelectMixersThroughPagesTest(String mixerTitle, String text) {
        HomePage homePage = new HomePage(getWebdriver());
        DropDownMenu dropDownMenu = homePage.clickShopByCategory();
        RestaurantFoodServicePage restaurantFoodServicePage = dropDownMenu.clickRestaurantFoodServiceButton();
        SearchBlock searchBlock = restaurantFoodServicePage.getSearchBlock();
        searchBlock.typeSearchText(text);
        ResultPage resultPage = searchBlock.clickSearchButton();
        List<String> names = resultPage.getResultsName();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(restaurantFoodServicePage.getTitle(mixerTitle, 5),
                "The title is not expected");
        names.forEach(name -> sa.assertTrue(name.contains(text.toLowerCase()),
                "The found item doesn't contain " + text + " word"));
        sa.assertAll();
    }

    @Test(testName = "verify cost filtering for any product", dataProvider = "productsData")
    public void verifyCostFilterForProductTest(String titleText, String text,BigDecimal cost) {
        HomePage homePage = new HomePage(getWebdriver());
        SearchBlock searchBlock = homePage.getSearchBlock();
        searchBlock.typeSearchText(text);
        ResultPage resultPage = searchBlock.clickSearchButton();
        List<String> names = resultPage.getResultsName();
        resultPage.selectCheckBoxByName("Under $" + cost);
        List<BigDecimal> prices = resultPage.getResultsPrice();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(resultPage.getTitle(titleText, 5), "The title is not expected");
        names.forEach(name -> {
            sa.assertTrue(name.contains(text),
                    "The found item doesn't contain " + text + " word");
        });
        prices.forEach(price -> {
            sa.assertTrue(cost.compareTo(price) > 0,
                    "The price doesn't less " + cost + " $");
        });
        sa.assertAll();
    }

    @Test(testName = "verify that dropdown brand filter is worked", dataProvider = "comMixerData")
    public void verifyFilterDropDownComMixersPageTest(String title, String text) {
        HomePage homePage = new HomePage(getWebdriver());
        DropDownMenu dropDownMenu = homePage.clickShopByCategory();
        RestaurantFoodServicePage restaurantFoodServicePage = dropDownMenu.clickRestaurantFoodServiceButton();
        CommercialMixerPage commercialMixerPage = restaurantFoodServicePage.clickComMixer();
        ResultPage resultPage = commercialMixerPage.chooseBrand();
        List<String> names = resultPage.getResultsName();
        resultPage.getTitle(title, 5);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(resultPage.getTitle(title, 5), "The title is not expected");
        names.forEach(name -> {
            sa.assertTrue(name.contains(text),
                    "The found item doesn't contain " + text + " word");
        });
    }
}
