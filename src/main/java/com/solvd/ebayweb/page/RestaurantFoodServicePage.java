package com.solvd.ebayweb.page;

import com.solvd.ebayweb.component.SearchBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestaurantFoodServicePage extends BasePage {

    @FindBy(xpath = "//*[@class='b-visualnav__title' and contains(text(),'Commercial Mixers')]")
    private WebElement comMixer;

    public RestaurantFoodServicePage(WebDriver driver) {
        super(driver);
    }

    public SearchBlock getSearchBlock() {
        return new SearchBlock(driver);
    }

    public CommercialMixerPage clickComMixer() {
        elementClick(comMixer, 5);
        return new CommercialMixerPage(driver);
    }
}
