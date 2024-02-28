package com.example.fiicodeapp.features.offapi;

import java.util.Arrays;

public class ProductInfo {
    private String name;
    private String nutritionGrade;
    private String[] ingredientsHierarchy;

    public ProductInfo(String name, String nutritionGrade, String[] ingredientsHierarchy) {
        this.name = name;
        this.nutritionGrade = nutritionGrade;
        this.ingredientsHierarchy = ingredientsHierarchy;
    }

    public ProductInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNutritionGrade() {
        return nutritionGrade;
    }

    public void setNutritionGrade(String nutritionGrade) {
        this.nutritionGrade = nutritionGrade;
    }

    public String[] getIngredientsHierarchy() {
        return ingredientsHierarchy;
    }

    public void setIngredientsHierarchy(String[] ingredientsHierarchy) {
        this.ingredientsHierarchy = ingredientsHierarchy;
    }

    @Override
    public String toString() {
        return "ProductIInfo{" +
                "name='" + name + '\'' +
                ", nutritionGrade='" + nutritionGrade + '\'' +
                ", ingredientsHierarchy=" + Arrays.toString(ingredientsHierarchy) +
                '}';
    }
}
