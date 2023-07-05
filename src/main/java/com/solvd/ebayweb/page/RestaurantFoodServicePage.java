package com.solvd.ebayweb.page;

import com.solvd.ebayweb.exception.NotClickedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestaurantFoodServicePage extends BasePage {
    @FindBy(xpath = "//*[@class='b-visualnav__title' and contains(text(),'Mixers')]")
    private WebElement mixersButton;
    public RestaurantFoodServicePage(WebDriver driver) {
        super(driver);
    }

    public CommercialMixersPage clickMixersButton() throws NotClickedException {
        elementClick(mixersButton, 5);
        return new CommercialMixersPage(driver);
    }
}
