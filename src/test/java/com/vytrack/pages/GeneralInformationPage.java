package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationPage extends BasePage{

    public GeneralInformationPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "div.pull-left>h1.user-name")
    public WebElement personalFullName;

    @FindBy(css = "a.email")
    public WebElement personalEmail;

    @FindBy(css = "a.phone")
    public WebElement personalPhone;

}
