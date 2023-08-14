package com.solvd.ebayweb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpProductPage extends BasePage {
    @FindBy(css = ".vi_oly_clz_cntr")
    WebElement closeButton;

    public PopUpProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickCloseButton() {
        waitItsClickable(closeButton,15);
        elementClick(closeButton, 15);
    }
}
