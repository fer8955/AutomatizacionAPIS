package com.nttdata.steps;

import com.nttdata.page.MercadoLibrePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MercadoLibreStep {
    WebDriver driver;
    MercadoLibrePage page;

    public MercadoLibreStep(WebDriver driver){
        this.driver = driver;
        page = new MercadoLibrePage(driver);
    }

    public void navegarA(String url){
        driver.get(url);
    }


    public void buscarProducto(String producto) throws InterruptedException {
        page.buscarEnBarraBusqueda(producto);
        page.clickEnLupaBarraBusqueda();
    }

    public void validarPrimerResultado(String nombreProducto){
        Assertions.assertEquals(nombreProducto, page.getTituloPrimerProducto());;
    }
}
