package com.news.sugar.models;

import java.util.ArrayList;

public class Cat  {

    String name=null;

    public ArrayList<Products> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Products> productList) {
        this.productList = productList;
    }

    ArrayList<Products> productList=null;

    public Cat(String name, ArrayList<Products> productList){
        this.name=name;
        this.productList=productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
