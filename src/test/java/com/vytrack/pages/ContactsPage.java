package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage{

    /*
    public ContactsPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    //Since we extend the BasePage and BasePage have the same constructor, we do not need to put this
    constructor here explicitly..
     */

    public WebElement getContactEmail(String email){
        String xPath = "//td[contains(text(), '" + email +  "')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xPath));
    }

    /*
    If we do not use singleton design model (Driver.get()), we should fix our method like this >
    public WebElement getContactEmail(WebDriver driver, String email){
        String xPath = "//td[contains(text(), '" + email +  "')][@data-column-label='Email']";
        return driver.findElement(By.xpath(xPath));
    }
    Of course, at the beginning, we should have constructor
     */

}
