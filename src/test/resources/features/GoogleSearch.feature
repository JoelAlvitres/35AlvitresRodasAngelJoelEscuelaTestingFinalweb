# language: es
@regresion
Característica: Búsqueda en Google

  @TEST-1 @GOOGLE
  Escenario: Abrir la página principal de Google
    Dado que el usuario abre la página de Google

  @TEST-2 @DuckDuckGo
  Escenario: Buscar conceptos de automatización
    Dado que el usuario está en la página de DuckDuckGo
    Cuando busca el término "Serenity BDD"
    Entonces debería ver resultados relacionados con "Serenity BDD"
