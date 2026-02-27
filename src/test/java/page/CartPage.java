package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(id = "checkout")
    private WebElementFacade checkoutBtn;

    @FindBy(id = "continue-shopping")
    private WebElementFacade continueShoppingBtn;

    @FindBy(css = ".title")
    private WebElementFacade pageTitle;

    public boolean estaEnCarrito() {
        return pageTitle.isVisible() && pageTitle.getText().trim().equalsIgnoreCase("Your Cart");
    }

    public void clickCheckout() {
        checkoutBtn.waitUntilClickable().click();
    }

    public void clickContinuarComprando() {
        continueShoppingBtn.waitUntilClickable().click();
    }

    public int obtenerCantidadProductos() {
        // Los ítems del carrito siempre tienen .cart_item
        List<WebElementFacade> items = findAll(By.cssSelector(".cart_item"));
        return items.size();
    }

    public boolean carritoEstaVacio() {
        return obtenerCantidadProductos() == 0;
    }

    public void removerProducto(String nombreProducto) {
        // Ubica el item por nombre y remueve con selector robusto
        WebElementFacade item = findBy(
                "//div[contains(@class,'cart_item')]" +
                        "[.//div[contains(@class,'inventory_item_name') and normalize-space()='" + nombreProducto + "']]"
        ).waitUntilVisible();

        item.find(By.cssSelector("button.btn_secondary, button.btn_inventory"))
                .waitUntilClickable()
                .click();

        // Espera a que desaparezca del DOM
        waitForCondition().until(driver ->
                findAll(
                        "//div[contains(@class,'cart_item')]" +
                                "[.//div[contains(@class,'inventory_item_name') and normalize-space()='" + nombreProducto + "']]"
                ).isEmpty()
        );
    }
}