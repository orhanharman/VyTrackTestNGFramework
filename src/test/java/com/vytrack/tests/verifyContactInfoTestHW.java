package com.vytrack.tests;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.GeneralInformationPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTestHW extends TestBase{

    /*
     * open the chrome browser
     * go to qa1.vytrack.com
     * login as a sales manager
     * navigate to customers -> contacts (module/tab)
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Test
    public void contactDetailsTest() {
        extentLogger = report.createTest("Contact Info Verification");

        //login as a sales manager
        //We can also use loginAsSalesManager method from LoginPage, but lets see this way as well
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        extentLogger.info("Login as a Sales Manager");
        loginPage.login(username, password);

        //navigate to customers -> contacts (module/tab)
        //Since we use this just one time, no need to use the long one, that is >
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Customer", "Contacts");
        extentLogger.info("Navigate to > Customer > Contacts");
        //new DashboardPage().navigateToModule("Customer", "Contacts");

        //click on email mbrackstone9@example.com via the method that we have created on ContactsPage page
        ContactsPage contactsPage = new ContactsPage();
        extentLogger.info("Click on 'mbrackstone9@example.com'");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        //verify that full name is Mariam Brackstone
        GeneralInformationPage generalInformationPage = new GeneralInformationPage();
        String actualFullName = generalInformationPage.personalFullName.getText();
        extentLogger.info("Verify fullname is " + actualFullName);
        Assert.assertEquals(actualFullName, "Mariam Brackstone", "Cannot verify full name");

        //verify that email is mbrackstone9@example.com
        String actualEmail = generalInformationPage.personalEmail.getText();
        extentLogger.info("Verify email is 'mbrackstone9@example.com'");
        Assert.assertEquals(actualEmail, "mbrackstone9@example.com", "Cannot verify email");

        //verify that phone number is +18982323434
        String actualPhone = generalInformationPage.personalPhone.getText();
        extentLogger.info("Verify phone number is '+18982323434'");
        Assert.assertEquals(actualPhone, "+18982323434", "Cannot verify phone number");

        extentLogger.pass("PASSED");

    }

    @Test
    public void loginAndCheckEmail2() {
        //login as a sales manager
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();

        //navigate to customers -> contacts (module/tab)
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Customers", "Contacts");

        //click on email demo.O@maildemo.com
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.getContactEmail("demo.O").click();

        //verify that full name is Demo Omed
        GeneralInformationPage generalInformationPage = new GeneralInformationPage();
        String actualFullName = generalInformationPage.personalFullName.getText();
        Assert.assertEquals(actualFullName, "Demo Omed", "Cannot verify full name");

        //verify that email is demo.O@maildemo.com
        String actualEmail = generalInformationPage.personalEmail.getText();
        Assert.assertEquals(actualEmail, "demo.O@maildemo.com", "Cannot verify email");

        //verify that phone number is 1234567890
        String actualPhone = generalInformationPage.personalPhone.getText();
        Assert.assertEquals(actualPhone, "1234567890", "Cannot verify phone number");

    }

}
