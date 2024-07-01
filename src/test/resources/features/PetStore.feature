Feature: Pet Store Orders

  @petstore
  Scenario Outline: Creación de una nueva mascota
    When se crea una nueva mascota con el ID <orderId> y el nombre de la mascota <petName>
    Then se valida el código de respuesta <statusCode>
    And se valida el contenido de la mascota creada con el ID <orderId> y el nombre de la mascota <petName>

    Examples:
      | orderId | petName | statusCode |
      | 40      | "Rex"   | 200        |
      | 20      | "Luna"  | 200        |
      | 44      | "Max"   | 200        |

  @petstore
  Scenario Outline: Consulta de una mascota existente
    Given que existe una mascota con el ID <orderId>
    When se consulta la mascota con el ID <orderId>
    Then se valida el código de respuesta <statusCode>

    Examples:
      | orderId | statusCode |
      | 19      | 200        |
      | 20      | 200        |
      | 99999   | 404        |
