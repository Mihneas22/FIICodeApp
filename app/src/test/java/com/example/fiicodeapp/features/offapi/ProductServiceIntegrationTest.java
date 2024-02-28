package com.example.fiicodeapp.features.offapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ProductServiceIntegrationTest {
    private final ProductsService productsService = new ProductsService();

    @Test
    public void when_getInformationAboutProduct_thenReturnProductInfo() {
        ProductInfo productInfo = productsService.getInformationAboutProduct("3017624010701");
        assertNotNull(productInfo);
        assertEquals("Nutella", productInfo.getName());
    }
}
