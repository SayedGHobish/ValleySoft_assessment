package LoginPage;

import PageBase.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends pageBase {
    public loginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="Email") public WebElement userMail;
    @FindBy(id="Password")public WebElement userPass;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")public WebElement loginBTN;

    public void login(String username, String password)
    {
        userMail.sendKeys(username);
        userPass.sendKeys(password);
        loginBTN.click();
    }

}
