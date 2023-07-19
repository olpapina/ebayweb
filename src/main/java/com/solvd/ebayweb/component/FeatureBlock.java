package com.solvd.ebayweb.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class FeatureBlock extends BaseComponent {
    public FeatureBlock(WebElement root) {
        super(root);
    }

    private static final Logger LOGGER = LogManager.getLogger(FeatureBlock.class);

    public void selectFeature() {
        List<WebElement> featureItems = root.findElements(By.xpath("//*[@class='x-msku__select-box']"));
        for (int j = 0; j < featureItems.size(); j++) {
            WebElement selectedElement;
            List<WebElement> featureItemFields;
            try {
                Select featureOptions = new Select(featureItems.get(j));
                featureItemFields = featureOptions.getOptions();
                featureItemFields = featureItemFields.stream()
                        .filter(feature -> feature.getAttribute("disabled") == null && !feature.getText().equals("- Select -"))
                        .collect(Collectors.toList());
                selectedElement = featureItemFields.get((int) (Math.random() * featureItemFields.size()));
                selectedElement.click();
            } catch (NoSuchElementException e) {
                LOGGER.error(featureItems.get(j).getAttribute("selectboxlabel") + " is not found");
            }
        }
    }
}
