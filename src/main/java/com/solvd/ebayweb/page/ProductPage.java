package com.solvd.ebayweb.page;

import com.solvd.ebayweb.component.FeatureBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'x-msku') and contains(@class,'vim')]")
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

    public int addToCart() {
        if (isElementDisplayed(featureBlock)) {
            FeatureBlock feature = new FeatureBlock(featureBlock);
            feature.selectFeature();
        }
        if (isElementDisplayed(addToCartButton)) {
            PopUpProductPage popUpProductPage = clickAddToCardButton();
            popUpProductPage.clickCloseButton();
            switchToWindow();
            return 1;
        } else {
            switchToWindow();
            return 0;
        }
    }

    public PopUpProductPage clickAddToCardButton() {
        elementClick(addToCartButton, 5);
        return new PopUpProductPage(driver);
    }
}
