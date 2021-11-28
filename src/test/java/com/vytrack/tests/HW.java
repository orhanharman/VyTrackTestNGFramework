package com.vytrack.tests;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.GeneralInformationPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW extends TestBase{

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    GeneralInformationPage generalInformationPage = new GeneralInformationPage();

    @Test
    public void TC01(){
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        //3. Navigate to “Activities -> Calendar Events”
        //4. Verify that page subtitle "Options" is displayed

        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        //4. Verify that page subtitle "Options" is displayed
        System.out.println("pageSubtitleOption=" + dashboardPage.pageSubtitleOption.getText());
        Assert.assertTrue(dashboardPage.pageSubtitleOption.isDisplayed(), "Cannot displayed 'Option'");
    }

    @Test
    public void TC02(){
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        //3. Navigate to “Activities -> Calendar Events”
        //4. Verify that page number is equals to "1"

        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        loginPage.loginAsStoreManager();

        //report steps
        extentLogger = report.createTest("Verify Page Number");
        extentLogger.info("Pre-conditions are loaded");
        extentLogger.info("Verify that page number is '1'");

        //3. Navigate to “Activities -> Calendar Events”
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        //4. Verify that page number is equals to "1"
        System.out.println("calendarEventsPage.pageNumber = " + calendarEventsPage.pageNumber.getAttribute("value"));
        Assert.assertTrue(calendarEventsPage.pageNumber.getAttribute("value").equals("1"));

        extentLogger.pass("Number is equals to '1'");
    }

    @Test
    public void TC03() throws InterruptedException {
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        //3. Navigate to “Activities -> Calendar Events”
        //4. Verify that view per page number is equals to "25"

        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        //we can use the wait method above or we can also use this to get the page number correctly >
        //wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.pageNumber));

        //4. Verify that view per page number is equals to "25"
        System.out.println("perPageNumber = " + calendarEventsPage.perPageNumber.getAttribute("innerHTML"));
        String number = calendarEventsPage.perPageNumber.getAttribute("innerHTML").split("<")[0].trim();
        System.out.println("per number = " + number);
        Assert.assertEquals(number, "25", "Cannot verify the per page number");
    }

    @Test
    public void TC04(){
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        //3. Navigate to “Activities -> Calendar Events”
        //4. Verify that number of calendar events (rows in the table) is equals to number of records

        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        //4. Verify that number of calendar events (rows in the table) is equals to number of records
        String str = calendarEventsPage.totalOfRecord.getAttribute("innerHTML");
        System.out.println(str);
        System.out.println("calendarEventsPage.list.size() = " + calendarEventsPage.list.size());
        int number = Integer.parseInt(str.split("of ")[1].split(" ")[0]);
        Assert.assertEquals(calendarEventsPage.list.size(), number);
    }

    @Test
    public void TC05(){
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        //3. Navigate to “Activities -> Calendar Events”
        //4. Click on the top checkbox to select all
        //5. Verify that all calendar events were selected

        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        //4. Click on the top checkbox to select all
        BrowserUtils.waitForClickablility(calendarEventsPage.allCheckbox, 15);
        calendarEventsPage.allCheckbox.click();
        System.out.println("list.size() = " + calendarEventsPage.list.size());

        //5. Verify that all calendar events were selected
        for (WebElement each : calendarEventsPage.list) {
            Assert.assertTrue(each.isSelected());
        }
    }

    @Test
    public void TC06(){
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        //3. Navigate to “Activities -> Calendar Events”
        //4. Select “Testers meeting”
        //5. Verify that following data is displayed:

        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        //4. Select “Testers meeting”
        BrowserUtils.waitForClickablility(calendarEventsPage.testersButton, 15);
        String expectedText = calendarEventsPage.testersButton.getText();
        System.out.println("expectedText = " + expectedText);
        calendarEventsPage.testersButton.click();

        //5. Verify that following data is displayed
        String actualText = generalInformationPage.personalFullName.getText();
        System.out.println("actualText = " + actualText);

        Assert.assertEquals(actualText, expectedText, "Verify 'Testers Meeting' name");
    }

    @Test
    public void TC07() throws InterruptedException {
        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        //3. Navigate to “Activities -> Calendar Events”
        //4. Use filter option and type 'testers meeting'

        //1. Go to “https://qa1.vytrack.com/"
        //2. Login as a store manager
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        //4. Use filter option and type 'testers meeting'
        //wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.filter));
        Thread.sleep(2000);
        calendarEventsPage.filter.click();
        //wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.title));
        Thread.sleep(2000);
        calendarEventsPage.title.click();
        Thread.sleep(2000);
        calendarEventsPage.containsBox.sendKeys("Testers Meeting");
        Thread.sleep(2000);
        calendarEventsPage.updateButton.click();
        String expectedText = calendarEventsPage.testersButton.getText();
        BrowserUtils.waitForVisibility(calendarEventsPage.testersButton, 5);
        Thread.sleep(2000);
        calendarEventsPage.testersButton.click();

        //5. Verify that following data is displayed
        String actualText = generalInformationPage.personalFullName.getText();
        System.out.println("actualText = " + actualText);

        Assert.assertEquals(actualText, expectedText, "Verify 'Testers Meeting' name");
    }

}
