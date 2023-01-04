Feature: Como administrados quiero crear un usuario nuevo

  Scenario: 01 - Creacion de usuario exitoso
    Given que el administrador ingresa al aplicativo
    When crea un usuario nuevo
    Then recibira un codigo de status create 201