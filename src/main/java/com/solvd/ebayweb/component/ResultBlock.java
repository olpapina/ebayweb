package com.solvd.ebayweb.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ResultBlock extends BaseComponent {
    @FindBy(xpath = "//*[@class='b-visualnav__title' and contains(text(),'Mixers')]")
    private List<WebElement> resultItems;


    public ResultBlock(WebElement root) {
        super(root);
    }

    public String getName() {
        return root.findElement(By.className("s-item__title")).getText();
    }

    public BigDecimal getPrice() {
        return new BigDecimal(
                root.findElement(By.className("s-item__price"))
                        .getText()
                        .replace("$", "")
        ).setScale(2, RoundingMode.UNNECESSARY);
    }

    public void clickProduct() {
        root.findElement(By.id("s-item__title")).click();
    }
}
