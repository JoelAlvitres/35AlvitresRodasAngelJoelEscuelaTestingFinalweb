package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import steps.SauceDemoSteps;

public class SauceDemoStepDefinitions {

    @Steps
    SauceDemoSteps sauce;

    // =========================
    // COMUNES
    // =========================
    @Dado("que el usuario abre la página de SauceDemo")
    public void queElUsuarioAbreLaPaginaDeSauceDemo() {
        sauce.abrirSauceDemo();
    }

    // =========================
    // LOGIN
    // =========================
    @Cuando("el usuario inicia sesión con tipo de usuario {string}")
    public void elUsuarioIniciaSesionConTipoDeUsuario(String tipoUsuario) {
        sauce.iniciarSesionConTipoUsuario(tipoUsuario);
    }

    @Cuando("ingresa las credenciales {string} y {string}")
    public void ingresaLasCredenciales(String usuario, String password) {
        sauce.iniciarSesion(usuario, password);
    }

    @Cuando("hace clic en login sin credenciales")
    public void haceClicEnLoginSinCredenciales() {
        sauce.iniciarSesion("", "");
    }

    @Entonces("debería ver la página de productos")
    public void deberiaVerLaPaginaDeProductos() {
        sauce.verificarPaginaProductos();
    }

    @Entonces("debería ver mensaje de error de login")
    public void deberiaVerMensajeDeErrorDeLogin() {
        sauce.verificarSeVisualizaMensajeErrorLogin();
    }

    @Entonces("debería ver mensaje de error {string}")
    public void deberiaVerMensajeDeError(String mensaje) {
        sauce.verificarMensajeErrorLogin(mensaje);
    }

    // =========================
    // PRODUCTOS
    // =========================
    @Entonces("debería ver {int} productos disponibles")
    public void deberiaVerProductosDisponibles(int cantidad) {
        sauce.verificarCantidadProductosVisibles(cantidad);
    }

    @Y("agrega el producto {string} al carrito")
    public void agregaProductoAlCarrito(String nombreProducto) {
        sauce.agregarProductoAlCarrito(nombreProducto);
    }

    @Y("remueve el producto {string} desde productos")
    public void remueveProductoDesdeProductos(String nombreProducto) {
        sauce.removerProductoDelCarrito(nombreProducto);
    }

    @Y("ordena los productos por {string}")
    public void ordenaLosProductosPor(String criterio) {
        sauce.ordenarProductos(criterio);
    }

    // =========================
    // CARRITO
    // =========================
    @Y("va al carrito de compras")
    public void vaAlCarritoDeCompras() {
        sauce.irAlCarrito();
    }

    @Entonces("el carrito debería mostrar {int} productos")
    public void elCarritoDeberiaMostrarProductos(int cantidad) {
        sauce.verificarCantidadProductosEnCarrito(cantidad);
    }

    @Entonces("debería ver {int} productos en el carrito")
    public void deberiaVerProductosEnElCarrito(int cantidad) {
        sauce.verificarCantidadProductosEnCartPage(cantidad);
    }

    @Y("remueve el producto {string} desde el carrito")
    public void remueveElProductoDesdeCarrito(String nombreProducto) {
        sauce.removerProductoDesdeCarrito(nombreProducto);
    }

    @Entonces("el carrito debería estar vacío")
    public void elCarritoDeberiaEstarVacio() {
        sauce.verificarCarritoVacio();
    }

    @Y("hace clic en continuar comprando")
    public void haceClicEnContinuarComprando() {
        sauce.continuarComprando();
    }

    @Entonces("debería estar en el carrito de compras")
    public void deberiaEstarEnElCarrito() {
        sauce.verificarEstaEnCarrito();
    }

    // =========================
    // CHECKOUT
    // =========================
    @Y("hace clic en checkout")
    public void haceClicEnCheckout() {
        sauce.procederAlCheckout();
    }

    @Entonces("debería estar en la página de información de checkout")
    public void deberiaEstarEnCheckoutInfo() {
        sauce.verificarEstaEnCheckoutInfo();
    }

    @Y("ingresa información de envío {string} {string} {string}")
    public void ingresaInformacionDeEnvio(String nombre, String apellido, String codigoPostal) {
        sauce.ingresarDatosEnvio(nombre, apellido, codigoPostal);
    }

    @Y("continúa al siguiente paso")
    public void continuaAlSiguientePaso() {
        sauce.continuarCheckout();
    }

    @Entonces("debería estar en la página de resumen de checkout")
    public void deberiaEstarEnCheckoutOverview() {
        sauce.verificarEstaEnCheckoutOverview();
    }

    @Y("finaliza la compra")
    public void finalizaLaCompra() {
        sauce.finalizarCompra();
    }

    @Entonces("debería ver el mensaje de orden completada")
    public void deberiaVerElMensajeDeOrdenCompletada() {
        sauce.verificarOrdenCompletada();
    }

    @Entonces("debería ver mensaje de error en checkout {string}")
    public void deberiaVerMensajeErrorEnCheckout(String mensaje) {
        sauce.verificarMensajeErrorCheckout(mensaje);
    }

    @Y("hace clic en volver a productos")
    public void haceClicEnVolverAProductos() {
        sauce.volverAProductos();
    }
}