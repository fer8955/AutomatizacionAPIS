package com.nttdata.steps;

import com.nttdata.screens.SauceProductScreen;
import org.junit.Assert;
import net.thucydides.core.annotations.Step;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.Assert;

public class SauceLabsProductSteps {
    SauceProductScreen productScreen;


    @Step
    public void validateProductGalleryLoad() {
        Assert.assertTrue(productScreen.isProductGalleryLoaded());
    }

    @Step
    public void addProductToCart(String productName, int units) {
        productScreen.selectProduct(productName);
        productScreen.waitForProductDetail();
        productScreen.setProductUnits(units);
        productScreen.addToCart();
    }

    @Step
    public void validateCartUpdate() {
        Assert.assertTrue(productScreen.isCartUpdatedCorrectly());
    }
}
