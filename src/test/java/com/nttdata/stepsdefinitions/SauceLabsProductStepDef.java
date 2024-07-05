package com.nttdata.stepsdefinitions;

import com.nttdata.steps.SauceLabsProductSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SauceLabsProductStepDef {
    @Steps
    SauceLabsProductSteps productSteps;

    @Given("estoy en la aplicación de Mydemoapp")
    public void estoyEnLaAplicacionDeMydemoapp() {
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        productSteps.validateProductGalleryLoad();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoDelSiguienteProducto(int unidades, String producto) {
        productSteps.addProductToCart(producto, unidades);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        productSteps.validateCartUpdate();
    }
}
