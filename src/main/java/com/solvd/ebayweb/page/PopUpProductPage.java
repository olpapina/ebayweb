package com.solvd.ebayweb.page;

import com.solvd.ebayweb.exception.NotClickedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpProductPage extends BasePage{


    @FindBy(css = ".vi_oly_clz_cntr")
    WebElement closeButton;

    @FindBy(css = ".viewAllLink")
    WebElement seeAllButton;

    public PopUpProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickCloseButton() throws NotClickedException {
        elementClick(closeButton,15);
    }

    public void clickSeeAllButton() throws NotClickedException {
        elementClick(seeAllButton,15);
    }
}
