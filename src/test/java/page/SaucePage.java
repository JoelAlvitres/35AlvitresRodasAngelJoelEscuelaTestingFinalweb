package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;

public class SauceDemoStepDefinitions {

    @Steps
    SauceDemoSteps sauceDemoSteps;

    // ✅ PASOS COMUNES
    @Dado("que el usuario abre la página de SauceDemo")
    public void queElUsuarioAbreLaPaginaDeSauceDemo() {
        sauceDemoSteps.abrirSauceDemo();
    }

    // ✅ PASOS DE LOGIN
    @Cuando("ingresa las credenciales {string} y {string}")
    public void ingresaLasCredencialesY(String usuario, String password) {
        sauceDemoSteps.iniciarSesion(usuario, password);
    }

    @Cuando("el usuario inicia sesión con tipo de usuario {string}")
    public void elUsuarioIniciaSesionConTipoDeUsuario(String tipoUsuario) {
        sauceDemoSteps.iniciarSesionConTipoUsuario(tipoUsuario);
    }

    @Cuando("hace clic en login sin credenciales")
    public void haceClicEnLoginSinCredenciales() {
        sauceDemoSteps.iniciarSesion("", "");
    }

    @Cuando("ingresa solo el usuario sin contraseña")
    public void ingresaSoloElUsuarioSinContrasena() {
        sauceDemoSteps.iniciarSesion("standard_user", "");
    }

    @Y("el usuario hace logout")
    public void elUsuarioHaceLogout() {
        sauceDemoSteps.hacerLogout();
    }

    @Entonces("debería estar en la página de login")
    public void deberiaEstarEnLaPaginaDeLogin() {
        sauceDemoSteps.verificarPaginaLogin(); // 👈 crea este método en SauceDemoSteps
    }

    // ✅ PASOS DE PRODUCTOS
    @Entonces("debería ver la página de productos")
    public void deberiaVerLaPaginaDeProductos() {
        sauceDemoSteps.verificarPaginaProductos();
    }

    @Entonces("debería ver {int} productos disponibles")
    public void deberiaVerProductosDisponibles(int cantidad) {
        sauceDemoSteps.verificarCantidadProductosVisibles(cantidad);
    }

    @Y("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String nombreProducto) {
        sauceDemoSteps.agregarProductoAlCarrito(nombreProducto);
    }

    @Y("remueve el producto {string} desde productos")
    public void remueveElProductoDesdeProductos(String nombreProducto) {
        sauceDemoSteps.removerProductoDelCarrito(nombreProducto);
    }

    @Y("ordena los productos por {string}")
    public void ordenaLosProductosPor(String criterio) {
        sauceDemoSteps.ordenarProductos(criterio);
    }

    @Entonces("debería ver los productos ordenados correctamente")
    public void deberiaVerLosProductosOrdenadosCorrectamente() {
        sauceDemoSteps.verificarPaginaProductos();
    }

    // ✅ PASOS DE CARRITO
    @Y("va al carrito de compras")
    public void vaAlCarritoDeCompras() {
        sauceDemoSteps.irAlCarrito();
    }

    @Entonces("el carrito debería mostrar {int} productos")
    public void elCarritoDeberiaMostrarProductos(int cantidad) {
        sauceDemoSteps.verificarCantidadProductosEnCarrito(cantidad);
    }

    @Entonces("debería ver {int} productos en el carrito")
    public void deberiaVerProductosEnElCarrito(int cantidad) {
        sauceDemoSteps.verificarCantidadProductosEnCartPage(cantidad);
    }

    @Y("remueve el producto {string} desde el carrito")
    public void remueveElProductoDesdeElCarrito(String nombreProducto) {
        sauceDemoSteps.removerProductoDesdeCarrito(nombreProducto);
    }

    @Entonces("el carrito debería estar vacío")
    public void elCarritoDeberiaEstarVacio() {
        sauceDemoSteps.verificarCarritoVacio();
    }

    @Y("hace clic en continuar comprando")
    public void haceClicEnContinuarComprando() {
        sauceDemoSteps.continuarComprando();
    }

    @Entonces("debería estar en el carrito de compras")
    public void deberiaEstarEnElCarritoDeCompras() {
        sauceDemoSteps.verificarEstaEnCarrito();
    }

    // ✅ PASOS DE CHECKOUT
    @Y("hace clic en checkout")
    public void haceClicEnCheckout() {
        sauceDemoSteps.procederAlCheckout();
    }

    @Y("ingresa información de envío {string} {string} {string}")
    public void ingresaInformacionDeEnvio(String nombre, String apellido, String codigoPostal) {
        sauceDemoSteps.ingresarDatosEnvio(nombre, apellido, codigoPostal);
    }

    @Y("continúa al siguiente paso")
    public void continuaAlSiguientePaso() {
        sauceDemoSteps.continuarCheckout();
    }

    @Y("finaliza la compra")
    public void finalizaLaCompra() {
        sauceDemoSteps.finalizarCompra();
    }

    @Y("ingresa solo apellido {string} y código postal {string}")
    public void ingresaSoloApellidoYCodigoPostal(String apellido, String codigoPostal) {
        sauceDemoSteps.ingresarSoloApellido(apellido);
        sauceDemoSteps.ingresarSoloCodigoPostal(codigoPostal);
    }

    @Y("ingresa solo nombre {string} y código postal {string}")
    public void ingresaSoloNombreYCodigoPostal(String nombre, String codigoPostal) {
        sauceDemoSteps.ingresarSoloNombre(nombre);
        sauceDemoSteps.ingresarSoloCodigoPostal(codigoPostal);
    }

    @Y("ingresa solo nombre {string} y apellido {string}")
    public void ingresaSoloNombreYApellido(String nombre, String apellido) {
        sauceDemoSteps.ingresarSoloNombre(nombre);
        sauceDemoSteps.ingresarSoloApellido(apellido);
    }

    @Y("cancela el checkout")
    public void cancelaElCheckout() {
        sauceDemoSteps.cancelarCheckout();
    }

    @Y("hace clic en volver a productos")
    public void haceClicEnVolverAProductos() {
        sauceDemoSteps.volverAProductos();
    }

    @Entonces("debería ver el mensaje de orden completada")
    public void deberiaVerElMensajeDeOrdenCompletada() {
        sauceDemoSteps.verificarOrdenCompletada();
    }

    @Entonces("debería estar en la página de información de checkout")
    public void deberiaEstarEnLaPaginaDeInformacionDeCheckout() {
        sauceDemoSteps.verificarEstaEnCheckoutInfo();
    }

    @Entonces("debería estar en la página de resumen de checkout")
    public void deberiaEstarEnLaPaginaDeResumenDeCheckout() {
        sauceDemoSteps.verificarEstaEnCheckoutOverview();
    }

    // ✅ PASOS DE VALIDACIÓN DE ERRORES
    @Entonces("debería ver mensaje de error {string}")
    public void deberiaVerMensajeDeError(String mensajeEsperado) {
        sauceDemoSteps.verificarMensajeErrorLogin(mensajeEsperado);
    }

    @Entonces("debería ver mensaje de error de login")
    public void deberiaVerMensajeDeErrorDeLogin() {
        sauceDemoSteps.verificarSeVisualizaMensajeErrorLogin();
    }

    @Entonces("debería ver mensaje de error en checkout {string}")
    public void deberiaVerMensajeDeErrorEnCheckout(String mensajeEsperado) {
        sauceDemoSteps.verificarMensajeErrorCheckout(mensajeEsperado);
    }
}