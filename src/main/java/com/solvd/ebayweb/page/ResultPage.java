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

    @FindBy(xpath = "//*[contains(@class,'x-refine__select__svg')]")
    private List<WebElement> checkBoxes;

    @FindBy(css = "#gh-la")
    private WebElement logo;

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
                isElementDisplayed(checkBoxes.get(i));
            }
        }
    }

    public HomePage addProductsToCart(Integer quantity) {

        for (int i = 0; i < quantity; i++) {
            ResultPage resultPage = new ResultPage(driver);
            int j = (int) (Math.random() * 60);
            ResultBlock resultBlock = new ResultBlock(resultPage.resultBlocks.get(j));
            resultBlock.clickProduct();
            ProductPage productPage = switchToProductPage();
            int notAdded = productPage.addToCart();
            if (notAdded == 0) {
                i--;
            }

        }
        clickLogo();
        return new HomePage(driver);
    }

    public ProductPage switchToProductPage() {
            switchToWindow();
            return new ProductPage(driver);
    }

    public void clickLogo() {
        elementClick(logo,5);
    }
}
