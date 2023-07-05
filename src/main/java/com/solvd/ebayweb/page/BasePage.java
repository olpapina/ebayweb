package com.solvd.ebayweb.pages;

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

    public void elementClick(WebElement webElement, long second) {
        waitItsClickable(webElement, second);
        try {
            if (webElement.isDisplayed()) {
                webElement.click();
                LOGGER.info(webElement.getTagName() + " is clicked");
                
        }
    }
