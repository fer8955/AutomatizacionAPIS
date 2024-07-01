package com.nttdata.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.policy.AssertionSet;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
import com.nttdata.model.ClasePet;

public class Pet {

    private String baseUrl = "https://petstore.swagger.io/v2";


    public void crearPet(int orderId, String petName) {
        try {
            String requestBody = "{\n" +
                    "  \"id\": " + orderId + ",\n" +
                    "  \"category\": {\n" +
                    "    \"id\": 1,\n" +
                    "    \"name\": \"zep\"\n" +
                    "  },\n" +
                    "  \"name\": \"" + petName + "\",\n" +
                    "  \"photoUrls\": [\n" +
                    "    \"string\"\n" +
                    "  ],\n" +
                    "  \"tags\": [\n" +
                    "    {\n" +
                    "      \"id\": 0,\n" +
                    "      \"name\": \"string\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"status\": \"available\"\n" +
                    "}";
            SerenityRest.given()
                    .baseUri(baseUrl)
                    .contentType("application/json")
                    .body(requestBody)
                    .when()
                    .post("/pet")
                    .then()
                    .log().all();
        } catch (Exception e) {
            throw new RuntimeException("Error al crear mascota", e);
        }
    }


    public void validarCodigoRespuesta(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, SerenityRest.lastResponse().statusCode());
    }

    public void consultarPet(int orderId) {
        SerenityRest.given()
                .baseUri(baseUrl)
                .when()
                .get("/store/order/{orderId}", orderId)
                .then()
                .log().all();
    }

    public boolean existePet(int orderId) {
        SerenityRest.given()
                .baseUri(baseUrl)
                .when()
                .get("/pet/{orderId}", orderId)
                .then()
                .log().all();

        return SerenityRest.lastResponse().statusCode() == 200;
    }

    public void validarContenidoMascota(int orderId, String expectedPetName) {
        ClasePet pet = SerenityRest.lastResponse().as(ClasePet.class);

        // Validar el ID de la mascota
        Assert.assertEquals("El ID de la mascota no coincide", orderId, pet.getId());

        // Validar el nombre de la mascota
        Assert.assertEquals("El nombre de la mascota no coincide", expectedPetName, pet.getName());

        // Mostrar mensaje de validación exitosa
        System.out.println("Se validó correctamente el ID y el nombre de la mascota.");
    }
}
