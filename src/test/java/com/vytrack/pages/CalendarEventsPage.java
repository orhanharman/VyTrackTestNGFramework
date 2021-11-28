package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "input[type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//label[@class='control-label']/../div/button")
    public WebElement perPageNumber;

    @FindBy(xpath = "//label[contains(text(),'Total of')]")
    public WebElement totalOfRecord;

    @FindBy(xpath = "//*[@class='btn btn-default btn-small dropdown-toggle']/input")
    public WebElement allCheckbox;

    @FindBy(xpath = "//td[contains(text(),'Testers Meeting')]")
    //or > //td[.='Testers Meeting']
    public WebElement testersButton;

    @FindBy(xpath = "//td[contains(@data-column-label, 'Selected')]/input")
    //or > //tbody//input[@data-role='select-row-cell']
    public List<WebElement> list;

    @FindBy(xpath = "//a[@title='Filters']")
    public WebElement filter;

    @FindBy(xpath = "//div[contains(text(),'Title')]")
    public WebElement title;

    @FindBy(xpath = "//input[@type='text'][@name='value']")
    public WebElement containsBox;

    @FindBy(xpath = "//button[.='Update']")
    public WebElement updateButton;

}
