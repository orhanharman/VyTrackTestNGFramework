package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationPage extends BasePage{

    public GeneralInformationPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".user-name")
    public WebElement personalFullName;

    @FindBy(xpath = "//a[contains(@href, 'mailto:')]")
    public WebElement personalEmail;

    @FindBy(xpath = "//a[contains(@href, 'tel:')]")
    public WebElement personalPhone;

}
