package RegisteTestCases;

import HomePage.homePage;
import ScreenShots.screenShots;
import TestBase.testBase;
import RegisterPage.registerPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestData.excelFile;
import java.io.IOException;

public class registerCases extends testBase {
    homePage homeObj;
    registerPage registerObj;

    @DataProvider(name="registerData")
    public Object [][] getExcelData() throws IOException
    {
        excelFile ES = new excelFile();
        return ES.getExcelData("userData.xlsx/");
    }

    @Test(dataProvider = "registerData")
    public void userRegister(String NameFirst, String SecondName,String Emails,String Company, String firstpass, String secondpass
            ,String day, String month, String year)
    {
        homeObj =new homePage(driver);
        registerObj = new registerPage(driver);
        waitForElementVisible(homeObj.registerBTN);
        homeObj.registerBTN.click();
        registerObj.confirmRegister(NameFirst, SecondName,Emails, Company,firstpass,secondpass);
        registerObj.selectBirthInfo(day, month, year);
        registerObj.submitted.click();
        waitForElementVisible(registerObj.registerDone);
        Assert.assertTrue(registerObj.registerDone.isDisplayed());
        try {
            screenShots.takeScreenshot(driver, "userRegister", registerObj.registerDone);
        } catch (IOException e) {
            throw new RuntimeException("can't find the element" +e.getMessage());
        }
    }

}
