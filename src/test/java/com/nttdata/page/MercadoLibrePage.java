package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MercadoLibrePage {
   private  WebDriver driver;
   private  By barraBusquedaInput =  By.xpath("//input[@id='cb1-edit']");
   private  By botonBusquedaInput = By.xpath("//form[@class=\"nav-search\"]/button[1]");
   private By  primerElementoInput2 = By.xpath("(//h3[@class=\"ui-search-item__title\"])[1]");
   private By  primerElementoInput = By.xpath("//a/h2[@class=\"poly-box\"]");
   private WebDriverWait wait;

   public MercadoLibrePage(WebDriver driver) {
      this.driver = driver;
      this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
   }

   public void  buscarEnBarraBusqueda(String texto) throws InterruptedException {
      wait.until(ExpectedConditions.visibilityOfElementLocated(barraBusquedaInput));
      WebElement barraBusqueda = driver.findElement(barraBusquedaInput);
      barraBusqueda.sendKeys(texto);
   }
   public void clickEnLupaBarraBusqueda() throws InterruptedException {
      wait.until(ExpectedConditions.elementToBeClickable(botonBusquedaInput));
      WebElement botonBusqueda = driver.findElement(botonBusquedaInput);
      botonBusqueda.click();
   }

   public String getTituloPrimerProducto(){

      WebElement primerElemento;
      try{
         wait.until(ExpectedConditions.visibilityOfElementLocated(primerElementoInput));
         primerElemento= driver.findElement(primerElementoInput);
      }catch (Exception e){
         wait.until(ExpectedConditions.visibilityOfElementLocated(primerElementoInput2));
         primerElemento= driver.findElement(primerElementoInput2);
      }

      //primerElemento.click();
      return primerElemento.getText();
   }
}
