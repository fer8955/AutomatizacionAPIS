@ProductTest
Feature: Sauce Labs Product Management

  @AddProduct
  Scenario Outline: Add product to cart
    Given estoy en la aplicación de Mydemoapp
    And valido que carguen correctamente los productos en la galeria
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente

    Examples:
      | PRODUCTO                | UNIDADES |
      | Sauce Labs Backpack     | 1        |
      | Sauce Labs Bolt - T-Shirt | 1      |
      | Sauce Labs Bike Light   | 2        |
