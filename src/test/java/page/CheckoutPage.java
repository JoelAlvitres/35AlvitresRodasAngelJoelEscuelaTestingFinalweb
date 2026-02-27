package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageObject {

    @FindBy(id = "first-name")
    private WebElementFacade firstName;

    @FindBy(id = "last-name")
    private WebElementFacade lastName;

    @FindBy(id = "postal-code")
    private WebElementFacade postalCode;

    @FindBy(id = "continue")
    private WebElementFacade continueBtn;

    @FindBy(id = "finish")
    private WebElementFacade finishBtn;

    @FindBy(id = "cancel")
    private WebElementFacade cancelBtn;

    @FindBy(css = ".complete-header")
    private WebElementFacade completeHeader;

    @FindBy(css = ".title")
    private WebElementFacade title;

    @FindBy(css = "[data-test='error']")
    private WebElementFacade error;

    @FindBy(id = "back-to-products")
    private WebElementFacade backHomeBtn;

    public void ingresarDatosCheckout(String nombre, String apellido, String codigoPostal) {
        firstName.waitUntilVisible().type(nombre);
        lastName.type(apellido);
        postalCode.type(codigoPostal);
    }

    public void ingresarNombre(String nombre) { firstName.waitUntilVisible().type(nombre); }
    public void ingresarApellido(String apellido) { lastName.type(apellido); }
    public void ingresarCodigoPostal(String codigoPostal) { postalCode.type(codigoPostal); }

    public void clickContinuar() { continueBtn.waitUntilClickable().click(); }
    public void clickFinalizar() { finishBtn.waitUntilClickable().click(); }
    public void clickCancelar() { cancelBtn.waitUntilClickable().click(); }

    public boolean estaOrdenCompletada() {
        return completeHeader != null
                && completeHeader.isCurrentlyVisible()
                && completeHeader.getText().contains("Thank you for your order");
    }

    public String obtenerMensajeCompletado() {
        return completeHeader.waitUntilVisible().getText();
    }

    public boolean estaEnPaginaCheckoutInfo() {
        return title.waitUntilVisible().getText().equals("Checkout: Your Information");
    }

    public boolean estaEnPaginaCheckoutOverview() {
        return title.waitUntilVisible().getText().equals("Checkout: Overview");
    }

    public boolean seVisualizaMensajeError() {
        return error != null && error.isCurrentlyVisible();
    }

    public String obtenerMensajeError() {
        return error.waitUntilVisible().getText();
    }

    public void volverAProductos() {
        backHomeBtn.waitUntilClickable().click();
    }
}