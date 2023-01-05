Feature: Como administrados quiero filtrar las reservas por id

  Scenario: 04 - como administrador necesito filtrar las reservas pot id
    Given que el administrador ingresa al aplicativo
    When consulta las reservas filtradas por id
    Then entonces resive un codigo de respuesta 200.