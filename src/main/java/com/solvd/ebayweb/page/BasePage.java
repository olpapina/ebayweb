package com.solvd.ebayweb.page;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public abstract class BasePage {
    protected WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitItsClickable(WebElement webElement, long second) {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(second))
                    .until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (NoSuchElementException e) {
            LOGGER.error("Element is not present on the page");
        }
    }

    public void elementClick(WebElement webElement, long second) {
        waitItsClickable(webElement, second);
        if (webElement.isDisplayed()) {
            LOGGER.info(webElement.getTagName() + " is clicked");
            webElement.click();
        }
    }

    public void typeText(WebElement webElement, String text, long second) {
        waitItsClickable(webElement, second);
        webElement.sendKeys(text);
        LOGGER.info("in the " + webElement.getAccessibleName() + " text " + text + " was typed");
    }

    public String getElementText(WebElement webElement) {
        waitItsClickable(webElement, 5);
        return webElement.getText();
    }

    public Boolean getTitle(String title, long second) {
        return new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until(ExpectedConditions.titleIs(title));
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            webElement.isDisplayed();
            LOGGER.info(webElement.getTagName() + " is present on the page");
            return true;
        } catch (NoSuchElementException e) {
            LOGGER.error("Element is not present on the page");
            return false;
        }
    }

    public void scrollToElement(WebElement webElement) {
        Actions action = new Actions(driver);
        action.scrollToElement(webElement).perform();
    }

    public void switchToWindow() {
        String parentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (windowHandles.size() < 3) {
                if (!parentWindow.equalsIgnoreCase(childWindow)) {
                    driver.switchTo().window(childWindow);
                    break;
                }
            } else {
                iterator.hasNext();
                String secondChildWindow = iterator.next();
                String thirdChildWindow = iterator.next();
                driver.switchTo().window(secondChildWindow);
                driver.close();
                windowHandles.remove(secondChildWindow);
                driver.switchTo().window(thirdChildWindow);
            }
        }
    }
}
