package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage{

    public ContactsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void clickPersonalMail(String emailName){
        String mailLocator = "//*[contains(text(), '" + emailName +  "')][@data-column-label='Email']";
        try {
            BrowserUtils.waitForClickablility(By.xpath(mailLocator), 5);
            WebElement mailElement = Driver.get().findElement(By.xpath(mailLocator));
            Driver.get().findElement(By.xpath(mailLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(mailLocator)),  5);
        }
    }

    /**
     *
     */

}
