@saucedemo
Feature: Login SauceDemo

  @happy @login
  Scenario: Login exitoso
    When inicio sesion con usuario "standard"
    Then debo ingresar al inventario

  @unhappy @login @locked
  Scenario: Login con usuario bloqueado
    When inicio sesion con usuario "locked"
    Then debo ver error que contenga "locked out"

  @unhappy @login @invalid
  Scenario: Login con usuario invalido
    When inicio sesion con usuario "invalid"
    Then debo ver error que contenga "do not match"