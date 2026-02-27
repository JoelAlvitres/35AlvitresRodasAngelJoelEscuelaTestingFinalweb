package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.saucedemo.com")
public class SauceLoginPage extends PageObject {

    private final By txtUsername = By.id("user-name");
    private final By txtPassword = By.id("password");
    private final By btnLogin    = By.id("login-button");
    private final By lblError    = By.cssSelector("[data-test='error']");

    public void login(String username, String password) {
        $(txtUsername).type(username);
        $(txtPassword).type(password);
        $(btnLogin).click();
    }

    public boolean errorVisible() {
        return $(lblError).isVisible();
    }

    public String errorText() {
        return $(lblError).getText();
    }
}