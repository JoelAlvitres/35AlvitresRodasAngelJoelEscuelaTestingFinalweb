package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * Page base / común para SauceDemo.
 * No contiene Steps ni StepDefinitions.
 * Solo utilidades y elementos comunes que se repiten en varias páginas.
 */
public class SaucePage extends PageObject {

    @FindBy(css = ".shopping_cart_link")
    protected WebElementFacade cartLink;

    @FindBy(css = ".shopping_cart_badge")
    protected WebElementFacade cartBadge;

    @FindBy(css = ".title")
    protected WebElementFacade pageTitle;

    // Menú lateral (logout)
    @FindBy(id = "react-burger-menu-btn")
    protected WebElementFacade menuButton;

    @FindBy(id = "logout_sidebar_link")
    protected WebElementFacade logoutLink;

    public String obtenerTitulo() {
        return pageTitle.waitUntilVisible().getText();
    }

    public void irAlCarrito() {
        cartLink.waitUntilClickable().click();
    }

    public int obtenerBadgeCarrito() {
        if (cartBadge == null || !cartBadge.isCurrentlyVisible()) return 0;
        String txt = cartBadge.getText().trim();
        return txt.isEmpty() ? 0 : Integer.parseInt(txt);
    }

    public void abrirMenu() {
        menuButton.waitUntilClickable().click();
    }

    public void logout() {
        abrirMenu();
        logoutLink.waitUntilClickable().click();
    }
}