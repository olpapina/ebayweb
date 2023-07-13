package com.solvd.ebayweb.component;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FeatureBlock extends BaseComponent {
    public FeatureBlock(WebElement root) {
        super(root);
    }

    public void selectFeature () throws InterruptedException {
        List<WebElement> featureItems = root.findElements(By.xpath("//*[@class='x-msku__select-box']"));
        for (int j = 0; j < featureItems.size(); j++) {
            WebElement fatherElement = root.findElement(By.xpath("//*[@id = 'x-msku__select-box-100" + j + "']"));
            List<WebElement> featureItemFields = root.findElements(By.xpath("//*[@id = 'x-msku__select-box-100" + j + "']//*[contains(@id,'x-msku__option-box')]"));
            for (int i = 1; i < featureItemFields.size(); i++) {
                if (featureItemFields.get(i).isEnabled()) {
                    fatherElement.click();
                    featureItemFields.get(i).click();
                    }
                    fatherElement.sendKeys(Keys.TAB);
                    break;
            }
        }
    }
}
