package steps;

import net.serenitybdd.annotations.Step;
import page.CartPage;
import page.CheckoutOverviewPage;
import page.SauceLoginPage;
import page.ProductsPage;
import utils.CredencialesHelper;

import static org.assertj.core.api.Assertions.assertThat;

public class SauceDemoSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    // ---------- Helpers ----------
    private void assertContainsIgnoreCase(String actual, String expected) {
        assertThat(actual).containsIgnoringCase(expected);
    }

    // ---------- Base ----------
    @Step("Abrir la página de SauceDemo")
    public void abrirSauceDemo() {
        loginPage.open();
        assertThat(loginPage.getDriver().getCurrentUrl()).contains("saucedemo");
    }

    // ---------- Login ----------
    @Step("Iniciar sesión con usuario y password")
    public void iniciarSesion(String usuario, String password) {
        loginPage.login(usuario, password);
    }

    @Step("Iniciar sesión con tipo de usuario")
    public void iniciarSesionConTipoUsuario(String tipoUsuario) {
        String u = CredencialesHelper.obtenerUsername(tipoUsuario);
        String p = CredencialesHelper.obtenerPassword(tipoUsuario);
        loginPage.login(u, p);
    }

    @Step("Verificar que la página de productos está visible")
    public void verificarPaginaProductos() {
        assertThat(productsPage.estaPaginaProductosVisible())
                .as("Se esperaba estar en Products")
                .isTrue();
    }

    @Step("Verificar mensaje de error en login")
    public void verificarMensajeErrorLogin(String mensajeEsperado) {
        String actual = loginPage.obtenerMensajeError();
        assertContainsIgnoreCase(actual, mensajeEsperado);
    }

    @Step("Verificar que se muestra mensaje de error en login")
    public void verificarSeVisualizaMensajeErrorLogin() {
        assertThat(loginPage.seVisualizaMensajeError())
                .as("Se esperaba un error visible en login")
                .isTrue();
    }

    // ---------- Productos ----------
    @Step("Agregar producto al carrito")
    public void agregarProductoAlCarrito(String nombreProducto) {
        productsPage.agregarProductoAlCarrito(nombreProducto);
    }

    @Step("Remover producto del carrito desde Products")
    public void removerProductoDelCarrito(String nombreProducto) {
        productsPage.removerProductoDelCarrito(nombreProducto);
    }

    @Step("Ordenar productos")
    public void ordenarProductos(String criterio) {
        productsPage.ordenarProductos(criterio);
    }

    @Step("Ir al carrito de compras")
    public void irAlCarrito() {
        productsPage.irAlCarrito();
        assertThat(cartPage.estaEnCarrito()).isTrue();
    }

    @Step("Verificar cantidad de productos en carrito (badge)")
    public void verificarCantidadProductosEnCarrito(int cantidad) {
        int badge = productsPage.obtenerCantidadProductosEnCarrito();
        assertThat(badge).isEqualTo(cantidad);
    }

    @Step("Verificar cantidad de productos visibles")
    public void verificarCantidadProductosVisibles(int cantidad) {
        int visibles = productsPage.obtenerCantidadProductosVisibles();
        assertThat(visibles).isEqualTo(cantidad);
    }

    // ---------- Carrito ----------
    @Step("Verificar que se está en carrito")
    public void verificarEstaEnCarrito() {
        assertThat(cartPage.estaEnCarrito()).isTrue();
    }

    @Step("Verificar cantidad de productos en CartPage")
    public void verificarCantidadProductosEnCartPage(int cantidad) {
        assertThat(cartPage.obtenerCantidadProductos()).isEqualTo(cantidad);
    }

    @Step("Remover producto desde el carrito")
    public void removerProductoDesdeCarrito(String nombreProducto) {
        cartPage.removerProducto(nombreProducto);
    }

    @Step("Verificar carrito vacío")
    public void verificarCarritoVacio() {
        assertThat(cartPage.carritoEstaVacio()).isTrue();
    }

    @Step("Continuar comprando")
    public void continuarComprando() {
        cartPage.clickContinuarComprando();
        assertThat(productsPage.estaPaginaProductosVisible()).isTrue();
    }

    // ---------- Checkout ----------
    @Step("Proceder al checkout")
    public void procederAlCheckout() {
        cartPage.clickCheckout();
        assertThat(checkoutPage.estaEnPaginaCheckoutInfo()).isTrue();
    }

    @Step("Ingresar datos de envío")
    public void ingresarDatosEnvio(String nombre, String apellido, String codigoPostal) {
        checkoutPage.ingresarDatosCheckout(nombre, apellido, codigoPostal);
    }

    @Step("Continuar checkout")
    public void continuarCheckout() {
        checkoutPage.clickContinuar();
    }

    @Step("Finalizar compra")
    public void finalizarCompra() {
        checkoutPage.clickFinalizar();
    }

    @Step("Verificar orden completada")
    public void verificarOrdenCompletada() {
        assertThat(checkoutPage.estaOrdenCompletada()).isTrue();
    }

    @Step("Verificar error checkout")
    public void verificarMensajeErrorCheckout(String mensajeEsperado) {
        assertThat(checkoutPage.seVisualizaMensajeError()).isTrue();
        assertContainsIgnoreCase(checkoutPage.obtenerMensajeError(), mensajeEsperado);
    }

    @Step("Verificar que está en Checkout Info")
    public void verificarEstaEnCheckoutInfo() {
        assertThat(checkoutPage.estaEnPaginaCheckoutInfo()).isTrue();
    }

    @Step("Verificar que está en Checkout Overview")
    public void verificarEstaEnCheckoutOverview() {
        assertThat(checkoutPage.estaEnPaginaCheckoutOverview()).isTrue();
    }

    @Step("Volver a productos")
    public void volverAProductos() {
        checkoutPage.volverAProductos();
        assertThat(productsPage.estaPaginaProductosVisible()).isTrue();
    }
}