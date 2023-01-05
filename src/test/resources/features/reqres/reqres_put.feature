Feature:Como administrador del aplicativo necesito
        actualizar los datos de un usuario

  Scenario: 02 - actualizacion de usuario exitosa
    Given que el administrador ingresa al aplicativo web
    When actualiza los datos de un usario registrado
    Then recibo un codigo de status 200