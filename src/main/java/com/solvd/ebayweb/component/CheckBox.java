package com.solvd.ebayweb.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBox extends BaseComponent {

    public CheckBox(WebElement root) {
        super(root);
    }

    public String getName() {
        return root.findElement(By.className("x-refine__multi-select-cbx")).getText();
    }

    public void clickCheckbox() {
        root.click();
    }
}
