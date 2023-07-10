package com.solvd.ebayweb.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ResultBlock extends BaseComponent {

    public ResultBlock(WebElement root) {
        super(root);
    }

    public String getName() {
        return root.findElement(By.className("s-item__title")).getText();
    }

    public BigDecimal getPrice() {
        String price = root.findElement(By.className("s-item__price"))
                        .getText()
                        .replace("$", "");
        String el = price.contains(" ") ? price.split(" ")[0] : price;
        return new BigDecimal(el).setScale(2, RoundingMode.UNNECESSARY);
    }

    public void clickProduct() {
        root.findElement(By.id("s-item__title")).click();
    }
}
