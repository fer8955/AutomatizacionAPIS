package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SauceProductScreen extends PageObject {

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']")
    private List<WebElement> productGallery;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/productTV']")
    private WebElement productTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Increase item quantity']")
    private WebElement increaseQuantityButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']")
    private WebElement productQuantity;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Tap to add product to cart']")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement cartIcon;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc='View cart']")
    private WebElement viewCartButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemsTV']")
    private WebElement cartItemCount;

    public boolean isProductGalleryLoaded() {
        waitFor(ExpectedConditions.visibilityOfAllElements(productGallery));
        return productGallery.size() > 1;
    }

    public void selectProduct(String productName) {
        WebElement product = getDriver().findElement(By.xpath("//android.widget.ImageView[@content-desc='" + productName + "']"));
        product.click();
    }

    public void waitForProductDetail() {
        waitFor(ExpectedConditions.visibilityOf(productTitle));
    }

    public void setProductUnits(int units) {
        for (int i = 1; i < units; i++) {
            increaseQuantityButton.click();
        }
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public boolean isCartUpdatedCorrectly() {
        String itemCountText = cartItemCount.getText();
        int cartItemCount = Integer.parseInt(itemCountText.split(" ")[0]);
        viewCartButton.click();
        waitFor(ExpectedConditions.visibilityOf(productTitle));
        int productPageItemCount = Integer.parseInt(productQuantity.getText());
        return cartItemCount == productPageItemCount;
    }
}
