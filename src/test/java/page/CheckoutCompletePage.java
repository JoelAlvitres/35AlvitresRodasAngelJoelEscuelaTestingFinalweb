package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends PageObject {

    @FindBy(css = ".title")
    private WebElementFacade pageTitle;

    @FindBy(css = ".complete-header")
    private WebElementFacade completeHeader;

    @FindBy(id = "back-to-products")
    private WebElementFacade backHomeButton;

    public boolean estaEnComplete() {
        return pageTitle.waitUntilVisible().getText().equals("Checkout: Complete!");
    }

    public String obtenerMensaje() {
        return completeHeader.waitUntilVisible().getText();
    }

    public boolean ordenCompletada() {
        return completeHeader.isVisible() && completeHeader.getText().contains("Thank you for your order");
    }

    public void clickBackHome() {
        backHomeButton.waitUntilClickable().click();
    }
}