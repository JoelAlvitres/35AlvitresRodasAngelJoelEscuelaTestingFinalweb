package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = ".title")
    private WebElementFacade pageTitle;

    @FindBy(id = "checkout")
    private WebElementFacade checkoutButton;

    @FindBy(id = "continue-shopping")
    private WebElementFacade continueShoppingButton;

    @FindBy(css = ".cart_item")
    private List<WebElementFacade> cartItems;

    @FindBy(css = ".shopping_cart_badge")
    private WebElementFacade cartBadge;

    public boolean estaEnCarrito() {
        return pageTitle.waitUntilVisible().getText().equals("Your Cart");
    }

    public int cantidadItemsEnCarrito() {
        return cartItems == null ? 0 : cartItems.size();
    }

    public void clickCheckout() {
        checkoutButton.waitUntilClickable().click();
    }

    public void clickContinuarComprando() {
        continueShoppingButton.waitUntilClickable().click();
    }

    public String obtenerBadgeCarrito() {
        return cartBadge.isVisible() ? cartBadge.getText() : "0";
    }

    // Remueve el primer item que exista (robusto)
    public void removerPrimerItemSiExiste() {
        if (cantidadItemsEnCarrito() == 0) return;
        // Dentro del primer cart_item hay un botón Remove con class btn_secondary / btn_small
        cartItems.get(0).thenFind("button.btn_secondary").waitUntilClickable().click();
    }
}