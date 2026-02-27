package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends SaucePage {

    @FindBy(css = ".inventory_item")
    private List<WebElementFacade> items;

    @FindBy(css = ".inventory_item_name")
    private List<WebElementFacade> itemNames;

    @FindBy(css = ".product_sort_container")
    private WebElementFacade sortDropdown;

    // título Products
    @FindBy(css = ".title")
    private WebElementFacade title;

    public boolean estaPaginaProductosVisible() {
        return title != null && title.isCurrentlyVisible() && title.getText().contains("Products");
    }

    public int obtenerCantidadProductosVisibles() {
        return items == null ? 0 : items.size();
    }

    public void agregarProductoAlCarrito(String nombreProducto) {
        WebElementFacade item = findBy(
                "//div[contains(@class,'inventory_item')]" +
                        "[.//div[contains(@class,'inventory_item_name') and normalize-space()='" + nombreProducto + "']]"
        ).waitUntilVisible();

        // OJO: CSS explícito para que no lo trate como XPATH
        item.find(By.cssSelector("button.btn_inventory"))
                .waitUntilClickable()
                .click();
    }

    public void removerProductoDelCarrito(String nombreProducto) {
        WebElementFacade item = findBy(
                "//div[contains(@class,'inventory_item')]" +
                        "[.//div[contains(@class,'inventory_item_name') and normalize-space()='" + nombreProducto + "']]"
        ).waitUntilVisible();

        item.find(By.cssSelector("button.btn_inventory"))
                .waitUntilClickable()
                .click();
    }

    public void ordenarProductos(String visibleText) {
        sortDropdown.waitUntilClickable().selectByVisibleText(visibleText);
    }

    public int obtenerCantidadProductosEnCarrito() {
        if (!containsElements(".shopping_cart_badge")) return 0;
        String txt = find(".shopping_cart_badge").waitUntilVisible().getText().trim();
        return txt.isEmpty() ? 0 : Integer.parseInt(txt);
    }
    public void hacerLogout() {
        logout(); // viene de SaucePage
    }

    // -------- Helpers privados --------

    private WebElementFacade botonAddToCart(String nombreProducto) {
        // dentro del card del producto, busca botón Add to cart
        String xpath = "//div[@class='inventory_item']//div[@class='inventory_item_name' and normalize-space()='%s']" +
                "/ancestor::div[@class='inventory_item']//button[contains(@id,'add-to-cart') or contains(.,'Add to cart')]";
        return find(By.xpath(String.format(xpath, nombreProducto)));
    }

    private WebElementFacade botonRemove(String nombreProducto) {
        String xpath = "//div[@class='inventory_item']//div[@class='inventory_item_name' and normalize-space()='%s']" +
                "/ancestor::div[@class='inventory_item']//button[contains(@id,'remove') or contains(.,'Remove')]";
        return find(By.xpath(String.format(xpath, nombreProducto)));
    }
    private WebElementFacade encontrarItem(String nombreProducto) {
        String xpath = "//div[contains(@class,'inventory_item')]"
                + "[.//div[contains(@class,'inventory_item_name') and normalize-space()='" + nombreProducto + "']]";
        return findBy(xpath).waitUntilVisible();
    }
}