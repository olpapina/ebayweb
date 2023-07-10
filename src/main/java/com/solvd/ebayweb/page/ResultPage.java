package com.solvd.ebayweb.page;

import com.solvd.ebayweb.component.CheckBox;
import com.solvd.ebayweb.component.ResultBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ResultPage extends BasePage{

    @FindBy(xpath = "//*[@id='srp-river-results']//*[contains(@class,'s-item__info')]")
    private List<WebElement> resultBlocks;

    @FindBy(xpath = "//*[@class='x-refine__multi-select']")
    private List<WebElement> checkBoxes;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultsName() {
        List<String> names = new ArrayList<>();
        resultBlocks.forEach(result -> {
            ResultBlock resultBlock = new ResultBlock(result);
            names.add(resultBlock.getName().toLowerCase());
        });
        return names;
    }

    public List<BigDecimal> getResultsPrice() {
        List<BigDecimal> prices =  new ArrayList<>();
        resultBlocks.forEach(result -> {
            ResultBlock resultBlock = new ResultBlock(result);
            prices.add(resultBlock.getPrice());
        });
        return prices;
    }

    public void selectCheckBoxByName(String name) {

        checkBoxes.forEach(boxName -> {
            CheckBox checkBox = new CheckBox(boxName);
            if (checkBox.getName().contains(name)) {
                checkBox.clickCheckBox(name);
            }
        });
    }
}
