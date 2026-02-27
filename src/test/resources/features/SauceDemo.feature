# language: es
@SAUCEDEMO
Característica: Flujo de compra y carrito en SauceDemo
  Para validar el comportamiento del ecommerce
  Como usuario
  Quiero autenticarme, administrar el carrito y completar (o fallar) el checkout

  # Nota: La apertura de la web se realiza en Hooks con @Before("@SAUCEDEMO")

  @SMOKE @LOGIN @HAPPYPATH
  Escenario: Acceso exitoso con usuario estándar
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Entonces debería ver la página de productos

  @LOGIN @UNHAPPYPATH
  Escenario: Bloqueo de acceso para usuario bloqueado
    Cuando el usuario inicia sesión con tipo de usuario "locked"
    Entonces debería ver mensaje de error "Sorry, this user has been locked out"

  @LOGIN @UNHAPPYPATH
  Escenario: Intento de login sin completar campos
    Cuando hace clic en login sin credenciales
    Entonces debería ver mensaje de error "Username is required"

  @LOGIN @UNHAPPYPATH
  Escenario: Intento de login sin contraseña
    Cuando ingresa solo el usuario sin contraseña
    Entonces debería ver mensaje de error "Password is required"

  @PRODUCTOS @HAPPYPATH
  Escenario: Visualizar catálogo luego de autenticarse
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Entonces debería ver 6 productos disponibles

  @CARRITO @HAPPYPATH
  Escenario: Agregar un ítem y validar badge del carrito
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Entonces el carrito debería mostrar 1 productos

  @CARRITO @HAPPYPATH
  Escenario: Agregar dos ítems y revisar el carrito
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y agrega el producto "Sauce Labs Bike Light" al carrito
    Y va al carrito de compras
    Entonces debería ver 2 productos en el carrito

  @CARRITO @UNHAPPYPATH
  Escenario: Abrir el carrito sin agregar productos
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y va al carrito de compras
    Entonces el carrito debería estar vacío

  @CARRITO @HAPPYPATH
  Escenario: Remover un producto desde el carrito
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y agrega el producto "Sauce Labs Bike Light" al carrito
    Y va al carrito de compras
    Y remueve el producto "Sauce Labs Backpack" desde el carrito
    Entonces debería ver 1 productos en el carrito

  @CARRITO @HAPPYPATH
  Escenario: Continuar comprando desde carrito
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en continuar comprando
    Entonces debería ver la página de productos

  @PRODUCTOS @HAPPYPATH
  Escenario: Ordenar por menor precio
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y ordena los productos por "Price (low to high)"
    Entonces debería ver los productos ordenados correctamente

  @PRODUCTOS @HAPPYPATH
  Escenario: Ordenar por nombre (Z a A)
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y ordena los productos por "Name (Z to A)"
    Entonces debería ver los productos ordenados correctamente

  @CHECKOUT @SMOKE @HAPPYPATH
  Escenario: Compra completa con un producto
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y ingresa información de envío "Juan" "Perez" "12345"
    Y continúa al siguiente paso
    Y finaliza la compra
    Entonces debería ver el mensaje de orden completada

  @CHECKOUT @HAPPYPATH
  Escenario: Verificar pantalla de información del checkout
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Entonces debería estar en la página de información de checkout

  @CHECKOUT @HAPPYPATH
  Escenario: Verificar pantalla de resumen antes de finalizar
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y ingresa información de envío "Carlos" "Rodríguez" "99999"
    Y continúa al siguiente paso
    Entonces debería estar en la página de resumen de checkout

  @CHECKOUT @UNHAPPYPATH
  Escenario: Validación de nombre obligatorio en checkout
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y ingresa solo apellido "Perez" y código postal "12345"
    Y continúa al siguiente paso
    Entonces debería ver mensaje de error en checkout "First Name is required"

  @CHECKOUT @UNHAPPYPATH
  Escenario: Validación de apellido obligatorio en checkout
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y ingresa solo nombre "Juan" y código postal "12345"
    Y continúa al siguiente paso
    Entonces debería ver mensaje de error en checkout "Last Name is required"

  @CHECKOUT @UNHAPPYPATH
  Escenario: Validación de código postal obligatorio en checkout
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y ingresa solo nombre "Juan" y apellido "Perez"
    Y continúa al siguiente paso
    Entonces debería ver mensaje de error en checkout "Postal Code is required"

  @CHECKOUT @UNHAPPYPATH
  Escenario: Cancelar checkout desde pantalla de información
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y cancela el checkout
    Entonces debería estar en el carrito de compras