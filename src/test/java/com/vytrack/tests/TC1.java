package com.vytrack.tests;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.GeneralInformationPage;
import com.vytrack.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 extends TestBase{

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
    public void loginAndCheckEmail() {
        //login as a sales manager
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();

        //navigate to customers -> contacts (module/tab)
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Customers", "Contacts");

        //click on email mbrackstone9@example.com
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.clickPersonalMail("mbrackstone");

        //verify that full name is Mariam Brackstone
        GeneralInformationPage generalInformationPage = new GeneralInformationPage();
        String actualFullName = generalInformationPage.personalFullName.getText();
        Assert.assertEquals(actualFullName, "Mariam Brackstone", "Cannot verify full name");

        //verify that email is mbrackstone9@example.com
        String actualEmail = generalInformationPage.personalEmail.getText();
        Assert.assertEquals(actualEmail, "mbrackstone9@example.com", "Cannot verify email");

        //verify that phone number is +18982323434
        String actualPhone = generalInformationPage.personalPhone.getText();
        Assert.assertEquals(actualPhone, "+18982323434", "Cannot verify phone number");

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
        contactsPage.clickPersonalMail("demo.O");

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
