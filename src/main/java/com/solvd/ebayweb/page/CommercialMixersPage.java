package com.solvd.ebayweb.page;

import com.solvd.ebayweb.component.ResultBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CommercialMixersPage extends BasePage{
    @FindBy(css = ".srp-results")
    private ResultBlock resultBlock;
    public CommercialMixersPage(WebDriver driver) {
        super(driver);
    }

    public ResultBlock getResultBlock() {
        return resultBlock;
    }
}
