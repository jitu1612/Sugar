package com.news.sugar.Adapters;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import com.news.sugar.models.Product;
import com.news.sugar.models.Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categories implements Serializable {


    // a recipe contains several ingredients
    private List<Products> products;
    private String name;

    public Categories(String names, ArrayList<Products> ingredients) {
        products = ingredients;
        name=names;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

}