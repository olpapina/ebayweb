package com.solvd.ebayweb.component;

import com.solvd.ebayweb.exception.NotClickedException;
import com.solvd.ebayweb.page.BasePage;
import com.solvd.ebayweb.page.RestaurantFoodServicePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownMenu extends BasePage {
    @FindBy(xpath = "//*[@class='scnd' and contains(text(), 'Restaurant & Food Service')]")
    private WebElement restaurantFoodServiceButton;
    public DropDownMenu(WebDriver driver) {
        super(driver);
    }

    public RestaurantFoodServicePage clickRestaurantFoodServiceButton() throws NotClickedException {
        elementClick(restaurantFoodServiceButton,5);
        return new RestaurantFoodServicePage(driver);
    }
}
