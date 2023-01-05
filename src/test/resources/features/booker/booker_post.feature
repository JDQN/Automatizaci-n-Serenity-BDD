Feature:Como usuario del aplicativo
        Booking necesito crear una reserva

  Scenario: 03 - como usuario necesito crear una reserva exitosa
    Given que el usuario ingresa al aplicativo booking
    When ingresa los datos del formulario de reserva
    Then se recibe un codigo stus 200
