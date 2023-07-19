package com.solvd.ebayweb.page;

import com.solvd.ebayweb.component.DropDownMenu;
import com.solvd.ebayweb.component.SearchBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    @FindBy(css = "#gh-la")
    private WebElement logo;

    @FindBy(css = "#vlGlobalFooter")
    private WebElement footer;

    @FindBy(css = ".hl-card-header__seeall")
    private WebElement seeAllButton;

    @FindBy(css = "#gdpr-banner-accept")
    private WebElement acceptAllButton;

    @FindBy(css = "#gh-shop-a")
    private WebElement shopByCategory;

    @FindBy(css = "#gh-cart-n")
    WebElement itemsInCartCount;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickLogo() {
        elementClick(logo, 5);
        return new HomePage(driver);
    }

    public DropDownMenu clickShopByCategory() {
        elementClick(shopByCategory, 10);
        return new DropDownMenu(driver);
    }

    public void clickAccessAllButton() {
        new WebDriverWait(this.driver, Duration.ofSeconds(5), Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(acceptAllButton));
        elementClick(acceptAllButton, 5);
    }

    public Boolean isClicked() {
        return acceptAllButton.isEnabled();
    }

    public SearchBlock getSearchBlock() {
        return new SearchBlock(driver);
    }

    public int getQuantityInCart() {
        return Integer.parseInt(getElementText(itemsInCartCount));
    }
}
