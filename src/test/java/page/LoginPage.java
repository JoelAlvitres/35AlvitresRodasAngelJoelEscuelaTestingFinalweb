package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    private WebElementFacade usernameInput;

    @FindBy(id = "password")
    private WebElementFacade passwordInput;

    @FindBy(id = "login-button")
    private WebElementFacade loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElementFacade errorMessage;

    public void login(String username, String password) {
        usernameInput.waitUntilVisible().clear();
        usernameInput.type(username);

        passwordInput.clear();
        passwordInput.type(password);

        loginButton.waitUntilClickable().click();
    }

    public boolean seVisualizaMensajeError() {
        return errorMessage != null && errorMessage.isCurrentlyVisible();
    }

    public String obtenerMensajeError() {
        return errorMessage.waitUntilVisible().getText();
    }
}