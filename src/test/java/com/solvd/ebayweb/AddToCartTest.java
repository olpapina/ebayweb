package com.solvd.ebayweb;

import com.solvd.ebayweb.component.SearchBlock;
import com.solvd.ebayweb.page.HomePage;
import com.solvd.ebayweb.page.ResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddToCartTest extends AbstractTest {

    @DataProvider(name = "addToCartText")
    public Object[][] dataTitle() {
        return new Object[][]{
                {"iphone", 3},
                {"samsung galaxy", 2}
        };
    }

    @Test(testName = "verify random product add to cart", dataProvider = "addToCartText")
    public  void verifyAddProductToCartTest(String product, Integer quantity) {
        HomePage homePage = new HomePage(getWebdriver());
        SearchBlock searchBlock = homePage.getSearchBlock();
        searchBlock.typeSearchText(product);
        ResultPage resultPage = searchBlock.clickSearchButton();
        homePage = resultPage.addProductsToCart(quantity);
        Assert.assertEquals(homePage.getQuantityInCart(), quantity, "Products quantity in cart doesn't match");
    }
}
