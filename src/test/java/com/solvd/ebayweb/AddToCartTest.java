package com.solvd.ebayweb;

import com.solvd.ebayweb.component.SearchBlock;
import com.solvd.ebayweb.exception.NotClickedException;
import com.solvd.ebayweb.page.HomePage;
import com.solvd.ebayweb.page.ResultPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddToCartTest extends AbstractTest {

    @DataProvider(name = "addToCartText")
    public Object[][] dataTitle() {
        return new Object[][]{
                {"iphone for sale | eBay", "iphone", 3}
        };
    }

    @Test(testName = "verify random product add to cart", dataProvider = "addToCartText")
    public  void verifyAddProductToCartTest(String title, String product, Integer quantity) throws NotClickedException, InterruptedException {
        HomePage homePage = new HomePage(getWebdriver());
        SearchBlock searchBlock = homePage.getSearchBlock();
        searchBlock.typeSearchText(product);
        ResultPage resultPage = searchBlock.clickSearchButton();
        resultPage.addProductsToCart(quantity);
    }
}
