Feature: Ejemplo de request


    Scenario: Prueba GET al endpoint
        Given I send a GET request to the https://api.github.com URI
        Then I get a 200 status code

    @API
    Scenario: Validar la cantidad de entradas en la respuesta.
        Given I send a GET request to the https://jsonplaceholder.typicode.com URI
        Then I validate there are 10 items on the /users endpoint

    Scenario: Validar que un elemento este en la respuesta
        Given I send a GET request to the https://jsonplaceholder.typicode.com URI
        Then I validate there is a value: Bre t in the response at /users endpoint