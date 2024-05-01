package RegisterPage;

import PageBase.pageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class registerPage extends pageBase {
    public registerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "page-title") public WebElement registerPage;

    @FindBy(id="gender-male") public WebElement maleGender;
    @FindBy(id="gender-female") public WebElement femaleGender;

    @FindBy(id="FirstName") public WebElement firstName;
    @FindBy(id="LastName") public WebElement lastName;
    @FindBy(id="Email") public WebElement emailField;
//    @FindBy(name = "DateOfBirthDay") public WebElement dayField;
//    @FindBy(name = "DateOfBirthMonth") public WebElement monthlyField;
//    @FindBy(name = "DateOfBirthYear") public WebElement yearField;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]") WebElement dayField;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]") WebElement monthlyField;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]") WebElement yearField;

    @FindBy(id = "Company") public WebElement companyField;
    @FindBy(id="Password") public WebElement password;
    @FindBy(id="ConfirmPassword")public WebElement confirmPass;
    @FindBy(id="register-button")public WebElement submitted;
    @FindBy(className = "result")public WebElement registerDone;

    public void confirmRegister(String first, String last,String email,String companyName, String passwords, String confirmPassword)
    {
        maleGender.click();
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        emailField.sendKeys(email);
        companyField.sendKeys(companyName);
        password.sendKeys(passwords);
        confirmPass.sendKeys(confirmPassword);
    }
    public void selectBirthInfo(String day, String month, String year) {
        WebElement element = dayField;
        Select select = new Select(element);
        select.selectByValue(day);

        element = monthlyField;
        select = new Select(element);
        select.selectByValue(month);

        element = yearField;
        select = new Select(element);
        select.selectByValue(year);
    }
}
