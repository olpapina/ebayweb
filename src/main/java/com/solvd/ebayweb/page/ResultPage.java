package com.solvd.ebayweb.page;

import com.solvd.ebayweb.component.CheckBox;
import com.solvd.ebayweb.component.ResultBlock;
import com.solvd.ebayweb.exception.NotClickedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ResultPage extends BasePage{

    @FindBy(xpath = "//*[@id='srp-river-results']//*[contains(@class,'s-item__info')]")
    private List<WebElement> resultBlocks;

    @FindBy(xpath = "//*[contains(@class,'x-refine__select__svg')]")
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

        for (int i =0; i < checkBoxes.size(); i++) {
            CheckBox checkBox = new CheckBox(checkBoxes.get(i));
            String selectedName = checkBox.getName();
            if (selectedName.contains(name)) {
                checkBox.clickCheckbox();
                checkElement(checkBoxes.get(i), 5);
            }
        }
    }

    public void addProductsToCart(Integer quantity) throws NotClickedException, InterruptedException {
        for (int i = 0; i <quantity; i++) {
            int j = (int) (Math.random()*60);
            ResultBlock resultBlock = new ResultBlock(resultBlocks.get(j));
            resultBlock.clickProduct();
            ProductPage productPage = switchToProductPage();
            productPage.addToCart();
        }
    }

    public ProductPage switchToProductPage() {
            switchToWindow();
            return new ProductPage(driver);
    }
}
