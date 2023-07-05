package com.solvd.ebayweb.page;

import com.solvd.ebayweb.component.DropDownMenu;
import com.solvd.ebayweb.exception.NotClickedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = "#gdpr-banner-accept")
    private WebElement cookieAcceptAllButton;

    @FindBy(css = "#gh-shop-a")
    private WebElement shopByCategory;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickCookieAcceptAllButton() throws NotClickedException {
        elementClick(cookieAcceptAllButton, 5);
    }

    public DropDownMenu clickShopByCategory() throws NotClickedException {
        elementClick(shopByCategory,5);
        return new DropDownMenu(driver);
    }
}
