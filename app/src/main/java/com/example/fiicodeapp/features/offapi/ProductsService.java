package com.example.fiicodeapp.features.offapi;

import pl.coderion.model.Product;
import pl.coderion.model.ProductResponse;
import pl.coderion.service.OpenFoodFactsWrapper;
import pl.coderion.service.impl.OpenFoodFactsWrapperImpl;

public class ProductsService {
    private final OpenFoodFactsWrapper wrapper = new OpenFoodFactsWrapperImpl();

    public ProductInfo getInformationAboutProduct(String barCode) {
        ProductResponse productResponse = wrapper.fetchProductByCode(barCode);
        Product product = productResponse.getProduct();
        String productName = product.getProductName();
        String productNutritionGrade = product.getNutritionGrades();
        String[] productIngredientsHierarchy = product.getIngredientsHierarchy();

        return new ProductInfo(productName, productNutritionGrade, productIngredientsHierarchy);
    }
}
