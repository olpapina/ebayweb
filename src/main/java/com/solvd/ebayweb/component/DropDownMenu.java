package com.solvd.ebayweb.component;

import com.solvd.ebayweb.page.BasePage;
import com.solvd.ebayweb.page.OtherVehiclesPage;
import com.solvd.ebayweb.page.RestaurantFoodServicePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownMenu extends BasePage {
    @FindBy(xpath = "//*[@class='scnd' and contains(text(), 'Restaurant & Food Service')]")
    private WebElement restaurantFoodServiceButton;

    @FindBy(xpath = "//*[@class='scnd' and contains(text(), 'Other vehicles')]")
    private WebElement otherPageButton;

    public DropDownMenu(WebDriver driver) {
        super(driver);
    }

    public RestaurantFoodServicePage clickRestaurantFoodServiceButton() {
        elementClick(restaurantFoodServiceButton, 5);
        return new RestaurantFoodServicePage(driver);
    }

    public OtherVehiclesPage clickOtherVehiclesPage() {
        elementClick(otherPageButton, 5);
        return new OtherVehiclesPage(driver);
    }
}
