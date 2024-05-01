package HomePage;

import PageBase.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends pageBase {
    public homePage(WebDriver driver) {
        super(driver);
    }
    //register button
    @FindBy(className = "ico-register") public WebElement registerBTN;
    //login button
    @FindBy(className = "ico-login") public WebElement loginBTN;
    //log out button
    @FindBy(className = "ico-logout") public WebElement logoutBTN;
}
