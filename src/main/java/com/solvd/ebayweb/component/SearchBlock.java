package com.solvd.ebayweb.component;

import com.solvd.ebayweb.page.BasePage;
import com.solvd.ebayweb.page.ResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBlock extends BasePage {
    @FindBy(xpath = "//*[contains(@class,'ui-autocomplete-input')]")
    private WebElement searchField;

    @FindBy(css = "#gh-btn")
    private WebElement searchButton;

    @FindBy(css = "#gh-cat-td")
    private WebElement searchCategory;

    public SearchBlock(WebDriver driver) {
        super(driver);
    }

    public void typeSearchText(String text) {
        typeText(searchField, text, 5);
    }

    public ResultPage clickSearchButton() {
        elementClick(searchButton, 5);
        return new ResultPage(driver);
    }

    public void selectSearchCategory(String text) {
        elementClick(searchCategory, 5);
        driver.findElement(By.xpath("//*[@id='gh-cat-box']//*[contains(text()," + text + ")]")).click();
    }
}
