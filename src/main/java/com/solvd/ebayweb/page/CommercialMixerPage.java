package com.solvd.ebayweb.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommercialMixerPage extends BasePage {

    @FindBy(xpath = "//ul/li/div[button[span[contains(text(),'Brand')]]]")
    WebElement brandDropDown;

    @FindBy(xpath = "(//*[contains(@class,'brm__aspect-item')])[2]")
    WebElement brandGlobe;

    public CommercialMixerPage(WebDriver driver) {
        super(driver);
    }

    public ResultPage chooseBrand() {
        elementClick(brandDropDown,5);
        elementClick(brandGlobe, 5);
        return new ResultPage(driver);
    }
}
