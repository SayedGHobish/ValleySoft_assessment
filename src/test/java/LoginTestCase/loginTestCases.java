package LoginTestCase;

import HomePage.homePage;
import LoginPage.loginPage;
import ScreenShots.screenShots;
import TestBase.testBase;
import TestData.excelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class loginTestCases extends testBase {
    homePage homeObj;
    loginPage loginObj;
    @DataProvider(name="loginData")
    public Object [][] getExcelData() throws IOException
    {
        excelFile ES = new excelFile();
        return ES.getExcelData("Login.xlsx/");
    }

    @Test(dataProvider = "loginData")
    public void userLoginDone(String LoginMail, String LoginPass)
    {
        homeObj = new homePage(driver);
        loginObj = new loginPage(driver);
        waitForElementVisible(homeObj.loginBTN);
        homeObj.loginBTN.click();
        loginObj.login(LoginMail,LoginPass);
        Assert.assertTrue(homeObj.logoutBTN.isDisplayed());
        try {

        screenShots.takeScreenshot(driver, "userLoginDone", homeObj.logoutBTN);
    } catch (IOException e) {
        throw new RuntimeException("can't find the element" +e.getMessage());
    }
    }

}
