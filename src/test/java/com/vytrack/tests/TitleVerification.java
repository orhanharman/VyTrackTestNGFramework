package com.vytrack.tests;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TitleVerification {

    @Test
    public void test(){

        Driver.get().get("https://qa1.vytrack.com/");

        //innerHTML and textContent works returning the String, but getText does not work
        String titleWeb = Driver.get().getTitle();
        String title = Driver.get().findElement(By.tagName("title")).getAttribute("textContent");
        System.out.println("titleWeb = " + titleWeb);
        System.out.println("title = " + title);
        Assert.assertEquals(titleWeb,title);
        Driver.closeDriver();

    }

}
