package com.solvd.ebayweb.page;

import com.solvd.ebayweb.exception.NotClickedException;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
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
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void elementClick(WebElement webElement, long second) throws NotClickedException, InvalidSelectorException {
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
        LOGGER.info("in the " + webElement.getAccessibleName() + " text " + text + " was typed");
    }

    public String getElementText(WebElement webElement) {
        return webElement.getText();
    }

    public Boolean getTitle(String title, long second) {
        return new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until(ExpectedConditions.titleIs(title));
    }

    public Boolean checkElement(WebElement webElement, long second) {
        waitItsClickable(webElement, second);
        if (webElement.isDisplayed()) {
            LOGGER.info(webElement.getTagName() + " is present on the page");
            return true;
        } else {
            LOGGER.info(webElement.getTagName() + " is not present on the page");
            return false;
        }
    }

    public void clickCoordinates(WebElement webElement, long second, Integer x, Integer y) {
        waitItsClickable(webElement, second);
        WebElement ele = driver.findElement(By.xpath(String.valueOf(webElement)));
        Actions action = new Actions(driver);
        action.moveToElement(ele, x, y).click().build().perform();
    }

    public void scrollToElement(WebElement webElement) {
        WebElement ele = driver.findElement(By.xpath(String.valueOf(webElement)));
        Actions action = new Actions(driver);
        action.scrollToElement(webElement).perform();
    }

    public void switchToWindow() {
        String parentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!parentWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }

    public void clearField(WebElement webElement) {
        webElement.clear();
    }
}
