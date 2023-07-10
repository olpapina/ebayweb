package com.solvd.ebayweb.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBox extends BaseComponent{
    @FindBy(xpath = "//*[contains(@class,'x-refine__multi-select-checkbox')]")
    WebElement checkBox;
    public CheckBox(WebElement root) {
        super(root);
    }

    public String getName() {
        return root.findElement(By.xpath("//*[contains(@class,'x-refine__multi-select-cbx')]")).getText();
    }

    public void clickCheckBox(String name) {
        root.findElement(By.xpath("//*[contains(@class,'x-refine__select__svg')]//*[contains(text()," + name+ ")]")).click();
    }
}
