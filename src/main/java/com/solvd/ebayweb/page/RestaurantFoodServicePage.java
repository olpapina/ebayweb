package com.solvd.ebayweb.page;

import com.solvd.ebayweb.component.SearchBlock;
import com.solvd.ebayweb.exception.NotClickedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestaurantFoodServicePage extends BasePage {

    @FindBy(xpath = "//*[@class='dialog__cell']//*[contains(text(),'Commercial Kitchen Equipment')]")
    private WebElement comKitchen;

    public RestaurantFoodServicePage(WebDriver driver) {
        super(driver);
    }

    public SearchBlock getSearchBlock() {
       return new SearchBlock(driver);
    }

    public void clickComKitchen() throws NotClickedException {
        elementClick(comKitchen, 5);
    }
}
