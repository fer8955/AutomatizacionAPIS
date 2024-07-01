package com.nttdata.glue;

import com.nttdata.steps.Pet;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStoreStepDefs {

    @Steps
    Pet pet;

    @When("se crea una nueva mascota con el ID {int} y el nombre de la mascota {string}")
    public void crearPet(int orderId, String petName) {
        pet.crearPet(orderId, petName);
    }

    @Then("se valida el código de respuesta {int}")
    public void validarCodigoRespuesta(int expectedStatusCode) {
        pet.validarCodigoRespuesta(expectedStatusCode);
    }


    @Given("que existe una mascota con el ID {int}")
    public void existePet(int orderId) {
        if (!pet.existePet(orderId)) {
            throw new RuntimeException("La orden con ID " + orderId + " no existe.");
        }
    }

    @When("se consulta la mascota con el ID {int}")
    public void consultarPet(int orderId) {
        pet.consultarPet(orderId);
    }


    @And("se valida el contenido de la mascota creada con el ID {int} y el nombre de la mascota {string}")
    public void seValidaElContenidoDeLaMascotaCreadaConElIDOrderIdYElNombreDeLaMascotaPetName(int orderId, String petName) {
        pet.validarContenidoMascota(orderId, petName);
    }

}
