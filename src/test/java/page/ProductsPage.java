package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends PageObject {

    @FindBy(css = ".title")
    private WebElementFacade pageTitle;

    @FindBy(css = ".shopping_cart_link")
    private WebElementFacade cartLink;

    @FindBy(css = "button.btn_inventory")
    private List<WebElementFacade> botonesAddOrRemove;

    @FindBy(css = ".shopping_cart_badge")
    private WebElementFacade cartBadge;

    public boolean estaEnProducts() {
        return pageTitle.waitUntilVisible().getText().equals("Products");
    }

    // Clic al primer botón que diga "Add to cart"
    public void agregarPrimerProductoDisponible() {
        // En SauceDemo los botones alternan Add/Remove, buscamos el que contenga "Add"
        for (WebElementFacade btn : botonesAddOrRemove) {
            String text = btn.getText();
            if (text != null && text.toLowerCase().contains("add")) {
                btn.waitUntilClickable().click();
                return;
            }
        }
        throw new AssertionError("No se encontró ningún botón 'Add to cart' (posible inventario vacío).");
    }

    public void irAlCarrito() {
        cartLink.waitUntilClickable().click();
    }

    public String obtenerBadgeCarrito() {
        return cartBadge.isVisible() ? cartBadge.getText() : "0";
    }
}