package com.solvd.ebayweb.page;

import com.solvd.ebayweb.exception.NotClickedException;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitItsClickable(WebElement webElement, long second) {
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void elementClick(WebElement webElement, long second) throws NotClickedException {
        waitItsClickable(webElement, second);
        if (webElement.isDisplayed()) {
            webElement.click();
            LOGGER.info(webElement.getTagName() + " is clicked");
        } else {
            throw new NotClickedException(webElement.getTagName() + " is not clicked");
        }
    }

    public void typeText(WebElement webElement, String text, long second) {
        waitItsClickable(webElement, second);
        webElement.sendKeys(text);
        LOGGER.info("in the " + webElement.getAccessibleName() + "text" + text + "was typed");
    }

    public String getElementText(WebElement webElement) {
        return webElement.getText();
    }

    public Boolean getTitle(String title, long second) {
        return new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until(ExpectedConditions.titleIs(title));
    }
}
