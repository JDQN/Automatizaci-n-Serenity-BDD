Feature: Como administrados quiero crear un usuario nuevo

  Scenario: 01 - Creacion d eusuario exitoso
    Given dado que el administrador ingresa al aplicativo
    When crea un usuario nuevo
    Then recibira un token de autenticacion