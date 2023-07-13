package com.solvd.ebayweb.page;

import com.solvd.ebayweb.component.FeatureBlock;
import com.solvd.ebayweb.exception.NotClickedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(css = ".x-msku" )
    WebElement featureBlock;

    @FindBy(css = "#qtyTextBox")
    WebElement quantity;

    @FindBy(xpath = "//*[@class='ux-call-to-action__text' and contains(text(),'Add to cart')]")
    WebElement addToCartButton;
    @FindBy(css = ".x-msku__error")
    WebElement errorMessage;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() throws NotClickedException, InterruptedException {
        if (checkElement(featureBlock, 5)) {
            FeatureBlock feature = new FeatureBlock(featureBlock);
            feature.selectFeature();
            elementClick(addToCartButton, 5);
            PopUpProductPage productPage = new PopUpProductPage(driver);
            productPage.clickSeeAllButton();
        }
        new ProductPage(driver);
    }
}
